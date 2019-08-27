import com.sun.org.apache.xpath.internal.Arg

class Args(val schema: Schema, parser: CommendParser) {
    private val inputArgs: List<InputArg>

    init {
        inputArgs = parser.inputs.map {
            val flag = schema.get(it.name) ?: throw IllegalArgumentException("不支持-${it.name}")
            try {
                val value = flag.parse(it.value) ?: throw IllegalArgumentException("不支持-${it.name}")
                InputArg(flag.name, value)
            } catch (e: Exception) {
                throw IllegalArgumentException("-${flag.name}接受${flag.type}值，但收到的是${it.value}")
            }
        }.toList()
    }

    fun getValue(s: String): Any {
        return inputArgs.firstOrNull() { it.name == s }?.value
                ?: schema.get(s)?.defaultValue
                ?: throw IllegalArgumentException("不支持-$s")
    }
}

class InputArg(val name: String, val value: Any)
