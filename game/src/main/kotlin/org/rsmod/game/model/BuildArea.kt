package org.rsmod.game.model

import org.rsmod.map.CoordGrid

@JvmInline
public value class BuildArea(public val base: CoordGrid) {

    public companion object {

        public val ZERO: BuildArea = BuildArea(CoordGrid.ZERO)
    }
}
