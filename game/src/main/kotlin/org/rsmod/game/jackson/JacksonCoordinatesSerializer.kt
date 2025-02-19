package org.rsmod.game.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.rsmod.game.map.CoordGrid

public object JacksonCoordinatesSerializer : StdSerializer<CoordGrid>(CoordGrid::class.java) {

    override fun serialize(value: CoordGrid, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeStartArray()
        gen.writeNumber(value.x)
        gen.writeNumber(value.z)
        gen.writeNumber(value.level)
        gen.writeEndArray()
    }
}
