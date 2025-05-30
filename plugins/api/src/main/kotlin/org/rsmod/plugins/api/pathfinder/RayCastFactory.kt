package org.rsmod.plugins.api.pathfinder

import org.rsmod.map.CoordGrid
import org.rsmod.game.pathfinder.LinePathFinder
import org.rsmod.game.pathfinder.RayCast
import org.rsmod.game.pathfinder.collision.CollisionFlagMap
import jakarta.inject.Inject

public class RayCastFactory @Inject constructor(flags: CollisionFlagMap) {

    private val linePathFinder: LinePathFinder = LinePathFinder(flags)

    public fun createLineOfSight(
        source: CoordGrid,
        destination: CoordGrid,
        srcSize: Int = 1,
        destWidth: Int = 0,
        destHeight: Int = 0
    ): RayCast {
        require(source.level == destination.level) { "`source` and `destination` must be on same level." }
        return linePathFinder.lineOfSight(
            level = source.level,
            srcX = source.x,
            srcZ = source.z,
            destX = destination.x,
            destZ = destination.z,
            srcSize = srcSize,
            destWidth = destWidth,
            destHeight = destHeight
        )
    }

    public fun createLineOfWalk(
        source: CoordGrid,
        destination: CoordGrid,
        srcSize: Int = 1,
        destWidth: Int = 0,
        destHeight: Int = 0
    ): RayCast {
        require(source.level == destination.level) { "`source` and `destination` must be on same level." }
        return linePathFinder.lineOfWalk(
            level = source.level,
            srcX = source.x,
            srcZ = source.z,
            destX = destination.x,
            destZ = destination.z,
            srcSize = srcSize,
            destWidth = destWidth,
            destHeight = destHeight
        )
    }
}
