val log4j2Version by extra("2.13.3")
val junitVersion by extra("5.6.2")

dependencies {
    // Use SLF4J with log4j2
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.apache.logging.log4j:log4j-core:$log4j2Version")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")

    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

//val test by tasks.getting(Test::class) {
//    // Use junit platform for unit tests
//    useJUnitPlatform()
//    testLogging.showStandardStreams = true
//}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging{
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}