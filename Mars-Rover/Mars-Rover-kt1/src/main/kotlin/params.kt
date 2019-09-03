data class Area(val x: Int, val y: Int)
data class Point(val x: Int, val y: Int) {
    fun addX(step: Int): Point {
        return Point(x + step, y)
    }

    fun addY(step: Int): Point {
        return Point(x, y + step)
    }
}

/**
 * N =north 北
 * E =east 东
 * S =south 南
 * W =west 西
 */
enum class Direction {
    N, E, S, W;

    fun toLeft(): Direction {
        val leftIndex = if (ordinal == 0) Direction.values().size - 1 else ordinal - 1
        return Direction.values()[leftIndex]
    }

    fun toRight(): Direction {
        val rightIndex = (ordinal + 1) % Direction.values().size
        return Direction.values()[rightIndex]
    }
}