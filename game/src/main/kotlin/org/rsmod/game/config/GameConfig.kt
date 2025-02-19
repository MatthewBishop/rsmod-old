package org.rsmod.game.config

import org.rsmod.map.CoordGrid
import org.rsmod.game.model.GameEnv
import java.nio.file.Path

public data class GameConfig(
    val name: String,
    val world: Int,
    val env: GameEnv,
    val dataPath: Path,
    val spawn: CoordGrid
)
