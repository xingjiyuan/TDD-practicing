import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import org.junit.jupiter.api.Assertions.*

internal class FizzBuzzDemoTest {
    @ParameterizedTest(name = "should return (0) given (1)")
    @CsvSource("'1', 1", "'Fizz', 3", "'Buzz', 5", "'FizzBuzz', 15")
    fun test(expected: String, given: Int) {
        assertEquals(expected, FizzBuzzDemo.of(given))
    }
}1`