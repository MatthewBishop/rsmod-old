version = "4.2.1"

plugins {
    `maven-publish`
//    signing
    kotlin("jvm")
    id("me.champeau.jmh") apply true
}

dependencies {
    jmh(libs.jacksonDatabind)
    jmh(libs.kotlinCoroutinesCore)
    testImplementation(libs.jacksonDatabind)
}

jmh {
    profilers.set(listOf("stack"))
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Pathfinder")
            description.set(
                """
                A custom BFS pathfinder implementation to emulate RS.
                """.trimIndent()
            )
        }
//        signing {
//            useGpgCmd()
//            sign(publishing.publications["maven"])
//        }
    }
}
