package org.rsmod.plugins.api.util

import org.rsmod.map.zone.ZoneGrid

@Suppress("MemberVisibilityCanBePrivate")
public object BuildAreaUtils {

    public const val SIZE: Int = 104

    // Rebuilds when you step into 2-zone boundary
    public const val REBUILD_BOUNDARY: Int = ZoneGrid.LENGTH * 2

    public const val ZONE_VIEW_RADIUS: Int = SIZE / REBUILD_BOUNDARY
}
