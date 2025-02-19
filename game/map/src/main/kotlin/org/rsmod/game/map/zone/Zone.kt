package org.rsmod.game.map.zone

import it.unimi.dsi.fastutil.bytes.Byte2IntMap
import org.rsmod.game.map.entity.obj.ObjectEntity
import org.rsmod.game.map.entity.obj.ObjectKey
import org.rsmod.map.square.MapSquareKey
import org.rsmod.game.map.util.collect.ImmutableObjectMap
import org.rsmod.game.map.util.collect.MutableObjectMap
import org.rsmod.map.zone.ZoneGrid
import org.rsmod.map.zone.ZoneKey

public data class Zone(public val staticObjects: ImmutableObjectMap) {

    public var dynamicObjects: MutableObjectMap? = null

    public operator fun set(key: ObjectKey, obj: ObjectEntity) {
        if (dynamicObjects == null) {
            dynamicObjects = MutableObjectMap.empty(DYNAMIC_OBJECT_MAP_INITIAL_CAP)
        }
        dynamicObjects?.set(key.packed, obj.packed)
    }

    public operator fun get(key: ObjectKey): Int? {
        return dynamicObjects?.get(key.packed) ?: staticObjects[key.packed]
    }

    public fun getValue(key: ObjectKey): Int {
        return this[key] ?: throw NoSuchElementException("Key $key is missing in the map.")
    }

    public fun entrySet(): Set<Byte2IntMap.Entry> {
        return dynamicObjects?.let { it.entrySet() + staticObjects.entrySet() }
            ?: staticObjects.entrySet()
    }

    public companion object {
        private const val DYNAMIC_OBJECT_MAP_INITIAL_CAP: Int = 16
    }
}

public fun ZoneKey.toViewport(zoneRadius: Int): List<MapSquareKey> {
    val lx = (x - zoneRadius) / ZoneGrid.LENGTH
    val lz = (z - zoneRadius) / ZoneGrid.LENGTH
    val rx = (x + zoneRadius) / ZoneGrid.LENGTH
    val rz = (z + zoneRadius) / ZoneGrid.LENGTH
    val viewport = mutableListOf<MapSquareKey>()
    for (mx in lx..rx) {
        for (mz in lz..rz) {
            val key = MapSquareKey(mx, mz)
            viewport += key
        }
    }
    return viewport
}
