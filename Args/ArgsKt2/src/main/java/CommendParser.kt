class CommendParser(input: String) {
    val inputs: MutableList<Input> = mutableListOf()

    init {
        val split = input.split(" ")
        split.forEachIndexed { index, s ->
            if (isArgName(s)) {
                inputs.add(Input(s.substring(1), if (index < split.size && !isArgName(split[index + 1])) split[index + 1] else ""))
            }
        }
    }

    private fun isArgName(s: String) = s.first() == '-' && (s.substring(1).isNotEmpty() && !s.substring(1).first().isDigit())

    fun size(): Int {
        return inputs.size
    }

    fun get(s: String): Any? {
        return inputs.firstOrNull { it.name == s }?.value
    }

}

class Input(val name: String, val value: String)
