package org.rsmod.game.model.mob

import org.rsmod.game.coroutines.GameCoroutine
import org.rsmod.game.coroutines.GameCoroutineScope
import org.rsmod.map.CoordGrid
import org.rsmod.game.model.client.MobEntity
import org.rsmod.game.model.clock.ClockMap
import org.rsmod.game.model.mob.info.ExtendedInfoMap
import org.rsmod.game.model.mob.move.MovementQueue
import org.rsmod.game.model.route.RouteRequest
import org.rsmod.game.model.vars.VariableMap

public sealed class Mob(
    public val coroutineScope: GameCoroutineScope = GameCoroutineScope(),
    public val movement: MovementQueue = MovementQueue()
) {

    public abstract val entity: MobEntity

    public val vars: VariableMap = VariableMap()

    public val clocks: ClockMap = ClockMap(vars)

    public val extendedInfo: ExtendedInfoMap = ExtendedInfoMap()

    public var index: Int
        get() = entity.index
        set(value) { entity.index = value }

    public var coords: CoordGrid
        get() = entity.coords
        set(value) { entity.coords = value }

    public var prevCoords: CoordGrid
        get() = entity.prevCoords
        set(value) { entity.prevCoords = value }

    public var activeCoroutine: GameCoroutine? = null
        private set

    public var routeRequest: RouteRequest? = null

    public fun launchCoroutine(block: suspend (GameCoroutine).() -> Unit): GameCoroutine {
        return coroutineScope.launch(block = block)
    }

    public fun launchStrictCoroutine(block: suspend GameCoroutine.() -> Unit): GameCoroutine {
        activeCoroutine?.cancel()
        val coroutine = coroutineScope.launch(block = block)
        if (coroutine.isSuspended) {
            activeCoroutine = coroutine
        }
        return coroutine
    }

    /**
     * This method is responsible for cleaning up any ongoing tasks
     * that the mob may be responsible for. This includes things such
     * as coroutines created by [coroutineScope]. If these coroutines
     * are not cancelled properly they may linger in memory and run
     * indefinitely.
     */
    public fun finalize() {
        coroutineScope.cancel()
    }
}
