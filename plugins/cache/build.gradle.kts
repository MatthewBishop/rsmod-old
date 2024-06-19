version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(projects.game.map)
    implementation(projects.plugins.types)
    implementation(libs.nettyBuffer)
    implementation(libs.openrs2Buffer)
    implementation(libs.openrs2Cache)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Cache")
            description.set(
                """
                A module defining loaders for animations, components, enums, graphics, interfaces,
                inventories, items, maps, NPCs, objects, parameters, scripts, structs, varbits, and varps in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
