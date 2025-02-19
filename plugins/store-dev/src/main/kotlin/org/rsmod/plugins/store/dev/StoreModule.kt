package org.rsmod.plugins.store.dev

import org.rsmod.game.scripts.module.KotlinScriptModule

class StoreModule : KotlinScriptModule() {

    init {
        install(DevPlayerStoreModule)
    }
}
