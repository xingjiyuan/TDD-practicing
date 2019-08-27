class Schema(val patterns: String) {
    private val flags: List<Flag> = patterns.split(" ").map { Flag(it) }

    fun size(): Int {
        return flags.size
    }

    fun get(s: String): Flag? {
        return flags.firstOrNull { it.name == s }
    }

}