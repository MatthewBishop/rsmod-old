version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Types")
            description.set(
                """
                A module defining various named types for animations, components, enums, graphics, interfaces,
                inventories, items, NPCs, objects, parameters, scripts, structs, varbits, and varps in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
