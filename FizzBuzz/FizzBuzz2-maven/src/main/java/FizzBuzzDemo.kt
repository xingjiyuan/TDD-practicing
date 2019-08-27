object FizzBuzzDemo {
    fun of(given: Int): String = when{
        isMultiple3(given) && isMultiple5(given) -> "FizzBuzz"
        isMultiple3(given) -> "Fizz"
        isMultiple5(given) -> "Buzz"
        else-> given.toString()
    }

    private fun isMultiple5(given: Int) = given % 5 == 0

    private fun isMultiple3(given: Int) = given % 3 == 0

}
