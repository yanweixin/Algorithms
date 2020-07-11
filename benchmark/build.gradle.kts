dependencies {
    implementation(project(":library"))
    implementation("org.openjdk.jmh:jmh-core:1.23")
    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.23")
}

tasks.register("jmh", JavaExec::class) {
    dependsOn(":library:assemble")
    group = "benchmark"
    main = "org.openjdk.jmh.Main"
    classpath = sourceSets["main"].runtimeClasspath
    // To pass parameters ("-h" gives a list of possible parameters)
    args(listOf("-f", "1", "-o", "build/summary.txt", "-rf", "json", "-rff", "build/output.json"))
}