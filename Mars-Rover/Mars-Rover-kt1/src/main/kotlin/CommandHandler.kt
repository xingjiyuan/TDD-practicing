class CommandHandler(val rover: MarsRover) {
    fun handleInitCommand(initCommandStr: String) {
        val mutableMapOf = mutableMapOf<String, String>()
        val initCommands = initCommandStr.split(",")
            .map { it.split("=") }
            .map { Command(it[0], it[1]) }.toList().also {
                it.forEach {
                    mutableMapOf.put(it.name, it.value)
                }
            }

        initArea(initCommands)
        initPosition(initCommands)
        initDirection(initCommands)
    }

    private fun initDirection(initCommands: List<Command>) {
        rover.direction = Direction.valueOf(initCommands.firstOrNull { it.name == "d" }?.value ?: "")
    }

    private fun initPosition(initCommands: List<Command>) {
        val xOfPosition = initCommands.firstOrNull { it.name == "x" }?.value?.toInt() ?: 0
        val yOfPosition = initCommands.firstOrNull { it.name == "y" }?.value?.toInt() ?: 0
        rover.position = Point(xOfPosition, yOfPosition)
    }

    private fun initArea(initCommands: List<Command>) {
        val xOfArea = initCommands.firstOrNull { it.name == "X" }?.value?.toInt() ?: 0
        val yOfArea = initCommands.firstOrNull { it.name == "Y" }?.value?.toInt() ?: 0
        rover.area = Area(xOfArea, yOfArea)
    }

    fun handleDirectionCommand(directionCommand: String) {
        when (directionCommand) {
            "l" -> rover.turnLeft()
            "r" -> rover.turnRight()
        }
    }

    fun splitOperateCommand(operateCommand: String): List<String> {
        return operateCommand.split(",")
    }
}

data class Command(val name: String, val value: String)