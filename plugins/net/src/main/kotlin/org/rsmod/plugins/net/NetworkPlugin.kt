package org.rsmod.plugins.net

import com.google.inject.Injector
import org.rsmod.game.scripts.plugin.KotlinScriptPlugin
import org.rsmod.plugins.api.core.GameProcessEvent
import org.rsmod.plugins.api.net.platform.game.GamePlatformPacketMaps
import org.rsmod.plugins.api.onEvent

class NetworkPlugin(injector: Injector) : KotlinScriptPlugin(injector) {

    private val platformPackets: GamePlatformPacketMaps by inject()

    init {
        onEvent<GameProcessEvent.BootUp> { platformPackets.eagerInitialize() }
    }
}
