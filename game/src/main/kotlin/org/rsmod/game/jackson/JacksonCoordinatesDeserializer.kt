package org.rsmod.game.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import org.rsmod.game.map.CoordGrid
import java.io.IOException

public object JacksonCoordinatesDeserializer : StdDeserializer<CoordGrid>(CoordGrid::class.java) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): CoordGrid {
        val array = ctxt.readValue(p, IntArray::class.java)
        if (array.size !in 2..3) throw IOException("Coordinates must contain 2 or 3 values. (received=$array)")
        return CoordGrid(array[0], array[1], if (array.size < 3) 0 else array[2])
    }
}
