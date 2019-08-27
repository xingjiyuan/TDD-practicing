object FizzBuzz {
    fun of(given: Int): String = when {
        given % 3 == 0 && given % 5 == 0  ->"FizzBuzz"
        given % 3 == 0 -> "Fizz"
        given % 5 == 0 -> "Buzz"
        else -> given.toString()
    }
}
