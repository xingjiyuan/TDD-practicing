class Schema(schemaSpec: String) {
    val specList: List<ArgSpec>

    init {
        fun List<String>.toArgSpec(): ArgSpec = ArgSpec(this[0], this[1])

        specList = schemaSpec.split(",").map {
            it.split(":").toArgSpec()
        }
    }
}

data class ArgSpec(val name: String, val type: String)