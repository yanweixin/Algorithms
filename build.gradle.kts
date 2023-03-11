plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.8.10"
    id("me.champeau.jmh") version "0.7.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "java-library")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    version = "0.0.1"
    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17
}

subprojects {
    dependencies {
        "implementation"(platform("org.jetbrains.kotlin:kotlin-bom"))
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

configure(subprojects - project(":benchmark")) {
    val slf4jVersion by extra("1.7.32")
    val log4j2Version by extra("2.14.1")
    val junitVersion by extra("5.8.1")
    val assertjVersion by extra("3.21.0")

    dependencies {
        // Use SLF4J with log4j2
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        implementation("org.apache.logging.log4j:log4j-core:$log4j2Version")
        implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")

        // Use JUnit Jupiter for testing.
        testImplementation(platform("org.junit:junit-bom:$junitVersion"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("org.assertj:assertj-core:$assertjVersion")

        // Use the Kotlin test library.
        testImplementation(kotlin("test"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
    tasks.processResources {
        from("$rootDir/config/resources")
    }

    if ("test" == parent?.name) {
        apply {
            plugin("me.champeau.jmh")
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