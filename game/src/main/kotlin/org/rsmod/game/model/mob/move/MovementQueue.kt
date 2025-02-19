package org.rsmod.game.model.mob.move

import org.rsmod.game.map.CoordGrid
import java.util.LinkedList
import java.util.Queue

public class MovementQueue(
    private val waypoints: Queue<CoordGrid> = LinkedList(),
    public var lastStep: CoordGrid = CoordGrid.ZERO,
    public var speed: MovementSpeed = DefaultMovementSpeed,
    public var noclip: Boolean = false
) : Queue<CoordGrid> by waypoints
