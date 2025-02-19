package org.rsmod.plugins.cache.map

import io.netty.buffer.ByteBuf
import org.openrs2.buffer.readUnsignedShortSmart
import org.rsmod.game.map.CoordGrid
import org.rsmod.game.map.square.MapSquareGrid
import org.rsmod.game.map.util.I14Coordinates
import org.rsmod.plugins.cache.map.loc.MapLoc
import org.rsmod.plugins.cache.map.loc.MapLocDefinition
import org.rsmod.plugins.cache.map.tile.TileOverlay
import org.rsmod.plugins.cache.map.tile.TileUnderlay
import org.rsmod.plugins.cache.readIncrUnsignedShortSmart

public object MapDefinitionLoader {

    public fun readMapDefinition(buf: ByteBuf): MapDefinition {
        val tileHeights = mutableMapOf<I14Coordinates, Int>()
        val overlays = mutableMapOf<I14Coordinates, TileOverlay>()
        val underlays = mutableMapOf<I14Coordinates, TileUnderlay>()
        val rules = mutableMapOf<I14Coordinates, Byte>()
        for (level in 0 until CoordGrid.LEVEL_COUNT) {
            for (x in 0 until MapSquareGrid.LENGTH) {
                for (z in 0 until MapSquareGrid.LENGTH) {
                    while (buf.isReadable) {
                        val opcode = buf.readUnsignedShort()
                        when {
                            opcode == 0 -> {
                                val coords = I14Coordinates(x, z, level)
                                tileHeights[coords] = Int.MIN_VALUE
                                break
                            }

                            opcode == 1 -> {
                                val coords = I14Coordinates(x, z, level)
                                tileHeights[coords] = buf.readUnsignedByte().toInt()
                                break
                            }

                            opcode <= 49 -> {
                                val id = buf.readShort().toInt()
                                if (id != 0) {
                                    val path = ((opcode - 2) shr 2)
                                    val rot = ((opcode - 2) and 0x3)
                                    val coords = I14Coordinates(x, z, level)
                                    overlays[coords] = TileOverlay((id - 1) and 0xFFFF, path, rot)
                                }
                            }

                            opcode <= 81 -> {
                                val coords = I14Coordinates(x, z, level)
                                rules[coords] = (opcode - 49).toByte()
                            }

                            else -> {
                                val coords = I14Coordinates(x, z, level)
                                val id = opcode - 81
                                underlays[coords] = TileUnderlay(id and 0xFF)
                            }
                        }
                    }
                }
            }
        }
        return MapDefinition(tileHeights, rules, overlays, underlays)
    }

    public fun readLocDefinition(buf: ByteBuf): MapLocDefinition {
        val locs = mutableListOf<MapLoc>()
        var currObjectId = -1
        while (buf.isReadable) {
            val offset = buf.readIncrUnsignedShortSmart()
            if (offset == 0) break
            currObjectId += offset
            var localCoords = 0
            while (buf.isReadable) {
                val diff = buf.readUnsignedShortSmart()
                if (diff == 0) break
                val attribs = buf.readUnsignedByte().toInt()
                localCoords += diff - 1
                locs += MapLoc(currObjectId, localCoords, attribs)
            }
        }
        return MapLocDefinition(locs)
    }
}
