package org.rsmod.plugins.api.pathfinder

import org.rsmod.map.CoordGrid
import org.rsmod.game.pathfinder.LineValidator
import org.rsmod.game.pathfinder.StepValidator
import org.rsmod.game.pathfinder.collision.CollisionFlagMap
import org.rsmod.plugins.api.model.Direction
import jakarta.inject.Inject

public class PathValidator @Inject constructor(flags: CollisionFlagMap) {

    private val lineValidator: LineValidator = LineValidator(flags)
    private val stepValidator: StepValidator = StepValidator(flags)

    public fun hasLineOfSight(
        source: CoordGrid,
        destination: CoordGrid,
        srcSize: Int = 1,
        destWidth: Int = 0,
        destHeight: Int = 0
    ): Boolean {
        require(source.level == destination.level) { "`source` and `destination` must be on same level." }
        return lineValidator.hasLineOfSight(
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

    public fun hasLineOfWalk(
        source: CoordGrid,
        destination: CoordGrid,
        srcSize: Int = 1,
        destWidth: Int = 0,
        destHeight: Int = 0
    ): Boolean {
        require(source.level == destination.level) { "`source` and `destination` must be on same level." }
        return lineValidator.hasLineOfWalk(
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

    public fun canStep(
        source: CoordGrid,
        direction: Direction,
        extraFlag: Int,
        srcSize: Int = 1,
        collision: CollisionType = CollisionType.Normal
    ): Boolean {
        return stepValidator.canTravel(
            level = source.level,
            x = source.x,
            z = source.z,
            offsetX = direction.offX,
            offsetZ = direction.offZ,
            size = srcSize,
            extraFlag = extraFlag,
            collision = collision.strategy
        )
    }
}
