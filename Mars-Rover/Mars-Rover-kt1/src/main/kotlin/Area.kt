data class Area(val x: Int, val y: Int)
data class Point(val x: Int, val y: Int)

/**
 * S =south 南
 * N =north 北
 * E =east 东
 * W =west 西
 */
enum class Direction {
    N, S, E, W
}