package org.rsmod.plugins.api

import org.rsmod.game.scripts.module.KotlinScriptModule

class ApiKModule : KotlinScriptModule() {

    init {
        install(APIModule)
    }
}
