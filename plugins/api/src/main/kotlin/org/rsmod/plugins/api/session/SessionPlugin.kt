package org.rsmod.plugins.api.session

import com.google.inject.Injector
import org.rsmod.game.scripts.plugin.KotlinScriptPlugin
import org.rsmod.plugins.api.model.event.ClientSession
import org.rsmod.plugins.api.model.event.PlayerSession
import org.rsmod.plugins.api.onEvent

class SessionPlugin(injector: Injector) : KotlinScriptPlugin(injector) {

    private val clientSession: ClientGameSession by inject()
    private val playerSession: PlayerGameSession by inject()

    init {
        onEvent<ClientSession.Connect> { clientSession.connect(client) }
        onEvent<ClientSession.Disconnect> { clientSession.disconnect(client) }

        onEvent<PlayerSession.LogIn> { playerSession.logIn(this) }
        onEvent<PlayerSession.LogOut> { playerSession.logOut(this) }
    }
}
