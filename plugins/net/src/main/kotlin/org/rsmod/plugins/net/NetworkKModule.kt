package org.rsmod.plugins.net

import org.rsmod.game.scripts.module.KotlinScriptModule

class NetworkKModule : KotlinScriptModule() {

    init {
        install(NetworkModule)
    }
}
