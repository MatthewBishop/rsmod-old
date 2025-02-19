package org.rsmod.plugins.api

import com.google.inject.Injector
import org.rsmod.game.scripts.plugin.KotlinScriptPlugin
import org.rsmod.game.model.route.RouteRequestCoordinates
import org.rsmod.plugins.api.model.event.UpstreamEvent

class ApiPlugin(injector: Injector) : KotlinScriptPlugin(injector) {

    init {
        onEvent<UpstreamEvent.MoveGameClick> { event ->
            // TODO: verify speed is valid for player (displace should be admins+, etc)
            routeRequest = RouteRequestCoordinates(event.coords, event.moveSpeed(), async = true)
        }
    }
}
