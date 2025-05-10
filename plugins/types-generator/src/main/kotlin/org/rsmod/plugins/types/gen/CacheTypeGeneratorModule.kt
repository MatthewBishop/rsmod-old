package org.rsmod.plugins.types.gen

import com.google.inject.AbstractModule
import org.rsmod.buffer.BufferModule
import org.rsmod.game.config.GameConfigModule
import org.rsmod.plugins.api.cache.CacheModule

public object CacheTypeGeneratorModule : AbstractModule() {

    override fun configure() {
        install(BufferModule)
        install(CacheModule)
        install(GameConfigModule)
    }
}
