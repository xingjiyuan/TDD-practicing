class Args(val schema: Schema) {
    private val inputHandler = InputHandler()
    fun handleInput(input: String) {
        inputHandler.handle(input)
    }

    fun get(name: String): Any {
        val inputValue = inputHandler.getInputValue(name)
        return when (schema.getTypeSpec(name)) {
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
