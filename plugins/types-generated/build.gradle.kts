
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    kotlin("jvm")
}

plugins.withType<KotlinPluginWrapper> {
    kotlin {
        explicitApi = ExplicitApiMode.Disabled
    }

    dependencies {
        implementation(libs.rsmodTypes)
    }

    sourceSets {
        main {
            java {
                srcDirs("src/main/gen")
            }
        }
    }
}
