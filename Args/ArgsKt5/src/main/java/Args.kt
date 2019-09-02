class Args(val schema: Schema) {
    val inputArgs = mutableListOf<InputArg>()
    fun handleInput(s: String) {
        inputArgs.clear()
        val split = s.split(" ")
        split.mapIndexed { index, s -> if (isArgName(s)) index else null }
                .filterNotNull()
                .toList()
                .mapTo(inputArgs) { InputArg(split[it].substring(1), if (it < split.lastIndex && !isArgName((split[it + 1]))) split[it + 1] else "") }
    }

    private fun isArgName(s: String) = s.startsWith("-") && s.length > 1 && !s[1].isDigit()

    fun get(s: String): Any {
        val typeSpec = schema.getTypeSpec(s)
        val inputValue: String? = getInputValue(s)
        return when (typeSpec) {
            "string" -> {
                inputValue ?: ""
            }
            "int" -> {
                inputValue?.toInt() ?: 0
            }
            "boolean" -> {
                if (inputValue == null) {
                    false
                } else if (inputValue.isEmpty()) {
                    true
                } else {
                    inputValue.toBoolean()
                }
            }
            else -> {
                throw NoSuchElementException()
            }
        }
    }

    private fun getInputValue(s: String) = inputArgs.firstOrNull { it.inputName == s }?.inputValue

    private fun Schema.getTypeSpec(s: String) = argSpecs.first { it.nameSpec == s }.typeSpec

    fun getInputArgsSize(): Int {
        return inputArgs.size
    }
}

data class InputArg(val inputName: String, val inputValue: String)