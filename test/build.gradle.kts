dependencies {
    api(project(":test:feature"))
    api(project(":test:leetcode"))
}

subprojects {
    dependencies {
        "jmh"("commons-io:commons-io:2.8.0")
    }
}

tasks.register("jmh") {
    dependsOn(":test:feature:jmh")
    dependsOn(":test:leetcode:jmh")
}