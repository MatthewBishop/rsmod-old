package org.rsmod.game.map.entity.obj

import org.rsmod.map.CoordGrid

public data class ObjectEntry(
    public val slot: Int,
    public val coords: CoordGrid,
    public val entity: ObjectEntity
)
