class Flag<T>(val name:String,val typeName:String, val defaultValue:T)
object FlagParser {
    fun parseDefaultValue(s: String): Any? {
        return when (s) {
            "integer" -> 0
            "string" -> ""
            "boolean" -> false
            "string[]" -> listOf<String>()
            "integer[]" -> listOf<Int>()
            else -> null
        }
    }

    fun parseFlagPattern(s: String): Flag<*> {
        val split = s.split(":")
        return Flag(split[0], split[1], parseDefaultValue(split[1]));
    }
}