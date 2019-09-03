class CommandHandler {
    fun handleInitCommand(initCommand: String): InitResult {
        val mutableMapOf = mutableMapOf<String, String>()
        initCommand.split(",")
            .map { it.split("=") }
            .forEach { mutableMapOf.put(it[0], it[1]) }
        val area = Area(mutableMapOf["X"]?.toInt() ?: 0, mutableMapOf["Y"]?.toInt() ?: 0)
        val point = Point(mutableMapOf["x"]?.toInt() ?: 0, mutableMapOf["y"]?.toInt() ?: 0)
        val direction = Direction.valueOf(mutableMapOf["d"] ?: "")
        return InitResult(area, point, direction)
    }

    fun handleDirectionCommand(directionCommand: String, rawDirection: Direction): Direction {
        return when (directionCommand) {
            "l" -> rawDirection.turnLeft()
            "r" -> rawDirection.turnRight()
            else -> rawDirection
        }
    }

}

data class InitResult(val area: Area, val point: Point, val direction: Direction)
