version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
    id("me.champeau.jmh") apply true
}

dependencies {
    implementation(libs.fastutil)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Map")
            description.set(
                """
                A module providing comprehensive utilities for handling game map coordinates, zones, map squares,
                and object entities in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
