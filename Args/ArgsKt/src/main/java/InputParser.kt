object InputParser {
    fun split(s: String): List<String> {
        return s.split(" ")
    }

    fun makePair(s: String): List<Pair<String, String>> {
        val split = split(s)
        val result = mutableListOf<Pair<String, String>>()
        split.forEachIndexed { index, s ->
            if (isFlag(s)) {
                result.add(Pair(s.substring(1),
                        if (index + 1 >= split.size || isFlag(split[index + 1])) ""
                        else split[index + 1]))
            }
        }

        return result
    }

    private fun isFlag(s: String) = s.startsWith("-")

}
