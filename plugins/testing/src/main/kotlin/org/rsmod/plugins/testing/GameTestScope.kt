package org.rsmod.plugins.testing

import org.rsmod.game.map.CoordGrid
import org.rsmod.game.map.entity.obj.ObjectEntity
import org.rsmod.game.model.client.Entity
import org.rsmod.game.model.client.PlayerEntity
import org.rsmod.game.model.mob.Player
import org.rsmod.game.model.mob.list.PlayerList
import org.rsmod.game.pathfinder.collision.CollisionFlagMap
import org.rsmod.plugins.api.map.GameObject
import org.rsmod.plugins.api.map.ObjectShape
import org.rsmod.plugins.api.pathfinder.BoundValidator
import org.rsmod.plugins.api.pathfinder.PathValidator
import org.rsmod.plugins.api.pathfinder.RayCastFactory
import org.rsmod.plugins.api.pathfinder.RouteFactory
import org.rsmod.plugins.api.pathfinder.StepFactory
import org.rsmod.plugins.cache.config.obj.ObjectTypeBuilder

public class GameTestScope {

    public val playerList: PlayerList = PlayerList()

    public fun withPlayer(
        player: Player = Player(),
        action: Player.() -> Unit
    ) {
        val index = playerList.nextAvailableIndex() ?: error("No available index.")
        playerList[index] = player
        action(player)
        player.finalize()
        playerList[index] = null
    }

    public fun withCollisionState(
        collision: CollisionFlagMap = CollisionFlagMap(),
        action: (GameCollisionState) -> Unit
    ) {
        val rf = RouteFactory(collision)
        val rcf = RayCastFactory(collision)
        val sf = StepFactory(collision)
        val pv = PathValidator(collision)
        val bv = BoundValidator(collision)
        action(GameCollisionState(collision, rf, rcf, sf, pv, bv))
    }

    public fun createEntity(): Entity {
        return PlayerEntity()
    }

    public fun createGameObject(
        coords: CoordGrid,
        rot: Int = 0,
        shape: ObjectShape = ObjectShape.CenterpieceStraight,
        init: ObjectTypeBuilder.() -> Unit
    ): GameObject {
        val builder = ObjectTypeBuilder().apply { id = 0 }
        val type = builder.apply(init).build()
        val entity = ObjectEntity(type.id, shape.id, rot)
        return GameObject(type, coords, entity)
    }
}
