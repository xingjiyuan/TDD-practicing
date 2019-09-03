data class Area(val x: Int, val y: Int)
data class Point(val x: Int, val y: Int)

/**
 * N =north 北
 * E =east 东
 * S =south 南
 * W =west 西
 */
enum class Direction {
    N, E, S, W;

    fun turnLeft(): Direction {
        val leftIndex = if (ordinal == 0) Direction.values().size - 1 else ordinal - 1
        return Direction.values()[leftIndex]
    }

    fun turnRight(): Direction {
        val rightIndex = (ordinal + 1) % Direction.values().size
        return Direction.values()[rightIndex]
    }
}