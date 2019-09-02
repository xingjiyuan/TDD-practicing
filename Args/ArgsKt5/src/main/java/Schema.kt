class Schema(s: String) {
    val argSpecs: List<ArgSpec>

    init {
        argSpecs = s.split(",").map {
            val split = it.split(":")
            ArgSpec(split[0], split[1])
        }
    }

    fun getSpecSize(): Int {
        return argSpecs.size
    }

}

data class ArgSpec(val nameSpec: String, val typeSpec: String)