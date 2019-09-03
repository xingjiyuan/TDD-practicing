class MarsRover {
    val handler = CommandHandler()
    fun getArea(): Area {
        return initResult?.area ?: Area(0, 0)
    }

    fun getPosition(): Point {
        return initResult?.point ?: Point(0, 0)
    }

    fun getDirection(): Direction {
        return initResult?.direction ?: Direction.S
    }

    fun report(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var initResult: InitResult? = null
    fun handleInitCommand(initCommand: String) {
        initResult = handler.handleInitCommand(initCommand)
    }

    fun handleOperateCommand(operateCommend: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
