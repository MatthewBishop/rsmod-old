version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(libs.guice)
    implementation(libs.jacksonDatabind)
    implementation(libs.jacksonKotlin)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod JSON")
            description.set(
                """
                A module providing support for JSON parsing and serialization using Jackson and Google Guice
                for dependency injection in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
