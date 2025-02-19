package org.rsmod.plugins.playground.login

import com.google.inject.Injector
import org.rsmod.game.scripts.plugin.KotlinScriptPlugin
import org.rsmod.plugins.api.model.event.PlayerSession
import org.rsmod.plugins.api.onEvent
import org.rsmod.plugins.api.openGameframe
import org.rsmod.plugins.content.gameframe.GameframePlugin

class GameframePlugin(injector: Injector) : KotlinScriptPlugin(injector) {

    private val gameframe: GameframePlugin by inject()

    init {
        onEvent<PlayerSession.Initialize> {
            openGameframe(gameframe.fixed)
        }
    }
}
