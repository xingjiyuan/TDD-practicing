class Flag(pattern: String) {
    val name: String
    val type: String
    val defaultValue: Any?

    init {
        val split = pattern.split(":")
        name = split[0]
        type = split[1]
        defaultValue = when (split[1]) {
            "Boolean" -> false
            "Int" -> 0
            "String" -> ""
            else -> null
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Flag

        if (name != other.name) return false
        if (defaultValue != other.defaultValue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (defaultValue?.hashCode() ?: 0)
        return result
    }

    fun parse(value: String?): Any? {
        if (value == null) return defaultValue
        return when (type) {
            "Boolean" -> parseBoolean(value)
            "Int" -> if (value.isEmpty()) defaultValue else value.toInt()
            "String" -> if (value.isEmpty()) defaultValue else value
            else -> null
        }
    }

    private fun parseBoolean(value: String) = when {
        value.isEmpty() -> true
        value.toLowerCase() == "false" || value.toLowerCase() == "true" -> value.toBoolean()
        else -> throw IllegalArgumentException()
    }
}