package org.rsmod.game.model.route

import org.rsmod.map.CoordGrid
import org.rsmod.game.model.mob.move.MovementSpeed

public data class RouteRequestCoordinates(
    public val destination: CoordGrid,
    public override val speed: MovementSpeed? = null,
    public override val async: Boolean = false
) : RouteRequest
