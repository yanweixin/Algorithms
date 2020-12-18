//val test by tasks.getting(Test::class) {
//    // Use junit platform for unit tests
//    useJUnitPlatform()
//    testLogging.showStandardStreams = true
//}
dependencies {
    api(project(":library:algorithm"))
    api(project(":library:lang"))
    api(project(":library:utils"))
}