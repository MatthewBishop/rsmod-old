version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(libs.guice)
    implementation(libs.jacksonDatabind)
    implementation(libs.jacksonKotlin)
    implementation(libs.jacksonToml)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod TOML")
            description.set(
                """
                A module providing support for TOML parsing and serialization using Jackson and Google Guice
                for dependency injection in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
