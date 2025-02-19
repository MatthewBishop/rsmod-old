package org.rsmod.plugins.content.gameframe

import org.rsmod.game.scripts.module.KotlinScriptModule

class GameframeKModule : KotlinScriptModule() {

    init {
        install(GameframeModule)
    }
}
