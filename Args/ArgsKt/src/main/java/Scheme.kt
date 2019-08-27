class Scheme(val flags: List<Flag<*>>) {
    fun getFlag(s: String): Flag<*> {
        return flags.first { it.name == s }
    }
}

object SchemeParser {
    fun parse(schemePattern: String): Scheme {
        val list = schemePattern.split(" ").map { FlagParser.parseFlagPattern(it) }.toList()
        return Scheme(list)
    }

}