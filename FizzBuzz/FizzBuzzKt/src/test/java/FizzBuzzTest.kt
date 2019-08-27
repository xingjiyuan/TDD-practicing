import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FizzBuzzTest {
    @ParameterizedTest(name = "should return (0) given (1)")
    @CsvSource("'1',1", "'Fizz', 3", "'Buzz',5", "'FizzBuzz', 15")
    internal fun test(expected: String, given: Int) {
        assertEquals(expected, FizzBuzz.of(given));
    }
}
