version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(libs.fastutil)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Events")
            description.set(
                """
                A module providing an event bus system for managing and publishing events in an RS-style game,
                supporting both unbound and keyed events.
                """.trimIndent()
            )
        }
    }
}
