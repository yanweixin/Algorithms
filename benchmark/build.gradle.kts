dependencies {
    implementation(project(":library"))
    implementation("org.openjdk.jmh:jmh-core:1.27")
    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.27")
}

tasks.register("jmh", JavaExec::class) {
    dependsOn(":library:assemble")
    group = "benchmark"
    main = "org.openjdk.jmh.Main"
    classpath = sourceSets["main"].runtimeClasspath
    // To pass parameters ("-h" gives a list of possible parameters)
    args(listOf("-f", "1", "-o", "build/summary.txt", "-rf", "json", "-rff", "build/output.json"))
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    archiveBaseName.set(project.name)
    archiveVersion.set("")
    archiveClassifier.set("")

    manifest {
        attributes("Main-Class" to "org.openjdk.jmh.Main")
        attributes(
            "Class-Path" to configurations.runtimeClasspath.get().files.joinToString(
                " lib/",
                "lib/"
            ) { it.name })
    }
}

tasks.create<Copy>("copyLib") {
    description = "Copies libraries to the lib directory"
    group = "Copy"
    from(configurations.runtimeClasspath)
    into("${buildDir}/libs/lib")
}

tasks.build {
    dependsOn("copyLib")
}