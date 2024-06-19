version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(libs.guice)
    implementation(libs.kotlinScriptCommon)
    implementation("io.github.classgraph:classgraph:4.8.158")
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Scripts")
            description.set(
                """
                A module providing support for loading and managing script plugins and module scripts with dependency injection,
                tailored for different environments (prod, dev, test) in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
