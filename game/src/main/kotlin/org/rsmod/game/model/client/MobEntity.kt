package org.rsmod.game.model.client

import org.rsmod.game.map.CoordGrid

public abstract class MobEntity(
    size: Int,
    public var index: Int = INVALID_INDEX
) : Entity(width = size, height = size) {

    public var prevCoords: CoordGrid = CoordGrid.ZERO

    public companion object {

        public const val INVALID_INDEX: Int = -1
    }
}
