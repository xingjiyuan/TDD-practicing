class MarsRover {
    val handler = CommandHandler(this)


    fun report(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var area: Area
    lateinit var position: Point
    lateinit var direction: Direction

    fun handleInitCommand(initCommand: String) {
        val initResult = handler.handleInitCommand(initCommand)
        area = initResult.area
        position = initResult.point
        direction = initResult.direction
    }

    fun handleOperateCommand(operateCommend: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
