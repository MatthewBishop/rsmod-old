package org.rsmod.plugins.api.info

import com.google.inject.Injector
import org.rsmod.game.scripts.plugin.KotlinScriptPlugin
import org.rsmod.plugins.api.info.player.PlayerInfoTask
import org.rsmod.plugins.api.model.event.PlayerSession
import org.rsmod.plugins.api.onEvent

class GpiPlugin(injector: Injector) : KotlinScriptPlugin(injector) {

    private val task: PlayerInfoTask by inject()

    init {
        onEvent<PlayerSession.Initialize> { task.initialize(this) }
        onEvent<PlayerSession.LogOut> { task.finalize(this) }
    }
}
