package org.rsmod.game.model.client

import org.rsmod.map.CoordGrid

public sealed class Entity(
    public val width: Int,
    public val height: Int,
    public var coords: CoordGrid = CoordGrid.ZERO
) {

    /**
     * Gets the maximum value between [width] and [height].
     */
    public val size: Int get() = width.coerceAtLeast(height)
}
