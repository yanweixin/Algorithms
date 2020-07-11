plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
}

allprojects {
    version = "0.0.1"

    repositories {
        // Use jcenter for resolving dependencies.
        // You can declare any Maven/Ivy/file repository here.
        jcenter()
    }

    apply(plugin = "java-library")
    apply(plugin = "org.jetbrains.kotlin.jvm")
}

subprojects {
    dependencies {
        "implementation"(platform("org.jetbrains.kotlin:kotlin-bom"))
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        "api"("org.apache.commons:commons-math3:3.6.1")
        "implementation"("com.google.guava:guava:29.0-jre")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "13"
        }
    }
}

tasks.register<Zip>("zip") {
    group = "Archive"
    from(project.rootDir)
    include("**")
    exclude(".*")
    exclude("**/build")
    archiveFileName.set("${project.name}-${project.version}.${Zip.ZIP_EXTENSION}")
}