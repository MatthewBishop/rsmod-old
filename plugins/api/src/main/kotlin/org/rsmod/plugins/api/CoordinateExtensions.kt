package org.rsmod.plugins.api

import org.rsmod.map.CoordGrid
import org.rsmod.map.zone.ZoneKey
import org.rsmod.game.model.BuildArea
import org.rsmod.plugins.api.util.BuildAreaUtils

public fun CoordGrid.toBuildArea(): BuildArea {
    val zoneViewRadius = BuildAreaUtils.ZONE_VIEW_RADIUS
    val baseZone = ZoneKey.from(this).translate(-zoneViewRadius, -zoneViewRadius)
    return BuildArea(baseZone.toCoords())
}
