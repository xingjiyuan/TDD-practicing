class MarsRover {
    val handler = CommandHandler(this)


    fun report(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var area: Area
    lateinit var position: Point
    lateinit var direction: Direction

    fun handleInitCommand(initCommand: String) {
        handler.handleInitCommand(initCommand)
    }

    fun handleOperateCommand(operateCommend: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun forward(step: Int) {
        position = when (direction) {
            Direction.N -> position.addY(step)
            Direction.E -> position.addX(step)
            Direction.S -> position.addY(-step)
            Direction.W -> position.addX(-step)
        }
    }

    fun backward(step: Int) {
        forward(-step)
    }

    fun turnLeft() {
        direction = direction.toLeft()
    }

    fun turnRight() {
        direction = direction.toRight()
    }

}
