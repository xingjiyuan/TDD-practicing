class Args(val schema: Schema) {
    private val handledList = mutableListOf<InputArg>()
    fun handleInput(input: String) {
        InputHandler().apply { handle(input) }.handledList.toCollection(handledList)
    }

    fun get(name: String): Any {
        val inputValue = handledList.firstOrNull { it.name == name }?.value
        return when (schema.specList.first { it.name == name }.type) {
            "int" -> {
                inputValue?.toInt() ?: 0
            }
            "boolean" -> {
                if (inputValue == null) {
                    return false
                }
                if (inputValue.isEmpty()) {
                    return true
                }
                return inputValue.toBoolean()
            }
            "string" -> {
                inputValue ?: ""
            }
            else -> {
                throw NoSuchElementException()
            }
        }
    }

}
