package org.rsmod.game.jackson

import com.fasterxml.jackson.databind.module.SimpleModule
import org.rsmod.game.config.GameConfig
import org.rsmod.map.CoordGrid
import jakarta.inject.Singleton

@Singleton
public class JacksonSimpleGameModule : SimpleModule() {

    init {
        addDeserializer(GameConfig::class.java, JacksonGameConfigDeserializer)

        addSerializer(CoordGrid::class.java, JacksonCoordinatesSerializer)
        addDeserializer(CoordGrid::class.java, JacksonCoordinatesDeserializer)
    }
}
