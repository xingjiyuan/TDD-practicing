class CommandHandler(val rover: MarsRover) {
    fun handleInitCommand(initCommand: String) {
        val mutableMapOf = mutableMapOf<String, String>()
        initCommand.split(",")
            .map { it.split("=") }
            .forEach { mutableMapOf.put(it[0], it[1]) }

        rover.area = Area(mutableMapOf["X"]?.toInt() ?: 0, mutableMapOf["Y"]?.toInt() ?: 0)
        rover.position = Point(mutableMapOf["x"]?.toInt() ?: 0, mutableMapOf["y"]?.toInt() ?: 0)
        rover.direction = Direction.valueOf(mutableMapOf["d"] ?: "")
    }

    fun handleDirectionCommand(directionCommand: String, rawDirection: Direction): Direction {
        return when (directionCommand) {
            "l" -> rawDirection.toLeft()
            "r" -> rawDirection.toRight()
            else -> rawDirection
        }
    }
}