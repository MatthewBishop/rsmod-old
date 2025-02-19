package org.rsmod.map

@JvmInline
public value class CoordGrid(public val packed: Int) {

    public val x: Int get() = (packed shr X_BIT_OFFSET) and X_BIT_MASK

    public val z: Int get() = (packed shr Z_BIT_OFFSET) and Z_BIT_MASK

    public val level: Int get() = (packed shr LEVEL_BIT_OFFSET) and LEVEL_BIT_MASK

    public constructor(x: Int, z: Int, level: Int = 0) : this(pack(x, z, level))

    public fun translate(xOffset: Int, zOffset: Int, levelOffset: Int = 0): CoordGrid = CoordGrid(
        x = x + xOffset,
        z = z + zOffset,
        level = level + levelOffset
    )

    public fun translateX(offset: Int): CoordGrid = translate(offset, 0, 0)

    public fun translateZ(offset: Int): CoordGrid = translate(0, offset, 0)

    public fun translateLevel(offset: Int): CoordGrid = translate(0, 0, offset)

    public operator fun minus(other: CoordGrid): CoordGrid {
        return translate(-other.x, -other.z, -other.level)
    }

    public operator fun plus(other: CoordGrid): CoordGrid {
        return translate(other.x, other.z, other.level)
    }

    public operator fun component1(): Int = x

    public operator fun component2(): Int = z

    public operator fun component3(): Int = level

    public override fun toString(): String {
        return "Coordinates(x=$x, z=$z, level=$level)"
    }

    @Suppress("MemberVisibilityCanBePrivate")
    public companion object {

        public val ZERO: CoordGrid = CoordGrid(0)
        public val NULL: CoordGrid = CoordGrid(-1)

        public const val X_BIT_COUNT: Int = 14
        public const val X_BIT_MASK: Int = (1 shl X_BIT_COUNT) - 1

        public const val Z_BIT_COUNT: Int = 14
        public const val Z_BIT_MASK: Int = (1 shl Z_BIT_COUNT) - 1

        public const val LEVEL_BIT_COUNT: Int = 2
        public const val LEVEL_BIT_MASK: Int = (1 shl LEVEL_BIT_COUNT) - 1
        public const val LEVEL_COUNT: Int = LEVEL_BIT_MASK + 1

        public const val Z_BIT_OFFSET: Int = 0
        public const val X_BIT_OFFSET: Int = Z_BIT_COUNT
        public const val LEVEL_BIT_OFFSET: Int = Z_BIT_COUNT + X_BIT_COUNT

        @Suppress("DuplicatedCode")
        private fun pack(x: Int, z: Int, level: Int): Int {
            if (x !in 0..X_BIT_MASK) {
                throw IllegalArgumentException("`x` value must be within range [0..$X_BIT_MASK].")
            } else if (z !in 0..Z_BIT_MASK) {
                throw IllegalArgumentException("`z` value must be within range [0..$Z_BIT_MASK].")
            } else if (level !in 0..LEVEL_BIT_MASK) {
                throw IllegalArgumentException("`level` value must be within range [0..$LEVEL_BIT_MASK].")
            }
            return ((x and X_BIT_MASK) shl X_BIT_OFFSET) or
                ((z and Z_BIT_MASK) shl Z_BIT_OFFSET) or
                ((level and LEVEL_BIT_MASK) shl LEVEL_BIT_OFFSET)
        }
    }
}
