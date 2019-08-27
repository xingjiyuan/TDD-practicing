class Args(inputPairs: List<Pair<String, String>>, scheme: Scheme) {
    private val args: List<Arg<*>> = scheme.flags.map { Arg.fromFlag(it) }.toList()

    constructor(input: String, scheme: String) : this(InputParser.makePair(input), SchemeParser.parse(scheme))

    init {

        inputPairs.forEach {
            val flag = scheme.getFlag(it.first)
            val arg = args.first { it.name == flag.name }
            try {
                when (flag.typeName) {
                    "boolean" ->
                        (arg as Arg<Boolean>).value =
                                getBooleanValue(it.second, true)
                    "integer" ->
                        (arg as Arg<Int>).value =
                                getIntValue(it.second, arg.value)
                    "string" ->
                        (arg as Arg<String>).value =
                                getStringValue(it.second, arg.value)
                    "string[]" ->
                        (arg as Arg<List<String>>).value =
                                getStringListValue(it.second, arg.value)
                    "integer[]" ->
                        (arg as Arg<List<Int>>).value =
                                getIntListValue(it.second, arg.value)
                }
            } catch (e: Exception) {
                throw IllegalArgumentException("-${it.first}接受${flag.typeName}类型的值，但实际收到的是${it.second}")
            }
        }
    }

    private fun getStringListValue(stringListValue: String, defaultValue: List<String>): List<String> {
        return if (stringListValue.isEmpty()) defaultValue else stringListValue.split(",")
    }

    private fun getIntListValue(intListValue: String, defaultValue: List<Int>): List<Int> {
        return if (intListValue.isEmpty()) defaultValue else intListValue.split(",").map { it.toInt() }
    }

    private fun getBooleanValue(booleanValue: String, defaultValue: Boolean): Boolean {
        return when (booleanValue) {
            "" -> defaultValue
            "true" -> true
            "false" -> false
            else -> throw IllegalArgumentException()
        }
    }

    private fun getIntValue(intValue: String, defaultValue: Int): Int {
        return if (intValue.isEmpty()) defaultValue else intValue.toInt()
    }

    private fun getStringValue(stringValue: String, defaultValue: String): String {
        return if (stringValue.isEmpty()) defaultValue else stringValue
    }


    fun size(): Int {
        return args.size;
    }

    fun get(givenFlagName: String): Any? {
        return args.firstOrNull { it.name == givenFlagName }?.value;
    }

}

class Arg<T>(val name: String, var value: T) {
    companion object {
        fun <T> fromFlag(flag: Flag<T>): Arg<T> {
            return Arg(flag.name, flag.defaultValue)
        }

    }
}