package org.rsmod.plugins.api.net.upstream.handler

import org.rsmod.game.map.CoordGrid
import org.rsmod.game.model.mob.Player
import org.rsmod.plugins.api.model.event.UpstreamEvent
import org.rsmod.plugins.api.net.upstream.MoveMinimapClick
import org.rsmod.plugins.api.publish

public class MoveMinimapClickHandler : UpstreamHandler<MoveMinimapClick>(MoveMinimapClick::class.java) {

    override fun handle(player: Player, packet: MoveMinimapClick) {
        val (mode, x, z) = packet
        val speed = UpstreamEvent.MoveGameClick.speedRequest(mode)
        val event = UpstreamEvent.MoveGameClick(speed, CoordGrid(x, z))
        player.publish(event)
    }
}
