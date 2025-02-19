package org.rsmod.plugins.cache.literal.codec

import org.rsmod.map.CoordGrid

public object CacheTypeCoordinate : CacheTypeBaseInt<CoordGrid>(CoordGrid::class.java) {

    override fun decode(value: Int): CoordGrid {
        return CoordGrid(value)
    }

    override fun encode(value: CoordGrid): Int {
        return value.packed
    }
}
