class InputHandler {
    val handledList = mutableListOf<InputArg>()
    fun handle(inputStr: String) {
        val split = inputStr.split(" ")
        split
                .mapIndexed { index, s -> if (s.isArgName()) index else null }
                .filterNotNull()
                .mapTo(handledList) { InputArg(split[it].substring(1), if (it < split.lastIndex && !split[it + 1].isArgName()) split[it + 1] else "") }
    }

    private fun String.isArgName() = startsWith("-") && length > 1 && !this[1].isDigit()

    fun handledSize(): Int {
        return handledList.size
    }

    fun getInputValue(name: String): String? {
        return handledList.firstOrNull { it.name == name }?.value
    }
}

data class InputArg(val name: String, val value: String)