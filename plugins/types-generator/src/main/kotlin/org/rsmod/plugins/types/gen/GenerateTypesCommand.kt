package org.rsmod.plugins.types.gen

import com.github.ajalt.clikt.core.CliktCommand
import com.google.inject.Guice
import org.rsmod.game.config.GameConfig
import org.rsmod.plugins.api.cache.name.CacheTypeNameLoader
import java.nio.file.Path

public fun main(args: Array<String>): Unit = GenerateTypesCommand().main(args)

public class GenerateTypesCommand : CliktCommand("generate-types") {

    override fun run() {
        val injector = Guice.createInjector(CacheTypeGeneratorModule)
        val generator = injector.getInstance(NamedTypeGenerator::class.java)
        val config = injector.getInstance(GameConfig::class.java)
        val cacheNameLoader = injector.getInstance(CacheTypeNameLoader::class.java)
        val cacheNames = cacheNameLoader.load()
        generator.writeConstFiles(
            names = cacheNames,
            outputPath = CONST_FILES_OUTPUT_PATH,
            packageName = CONST_FILES_PACKAGE
        )
        generator.writeConfigMapFiles(
            names = cacheNames,
            outputPath = config.dataPath.resolve("names/cache"),
        )
    }

    public companion object {

        public const val CONST_FILES_PACKAGE: String = "org.rsmod.types"

        public val CONST_FILES_OUTPUT_PATH: Path = Path.of(
            "plugins/types-generated/src/main/gen/${CONST_FILES_PACKAGE.replace(".", "/")}"
        )
    }
}
