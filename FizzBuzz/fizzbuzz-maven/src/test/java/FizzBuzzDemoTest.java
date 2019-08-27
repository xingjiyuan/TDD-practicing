import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzDemoTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource({
            "'1', 1",
            "'Fizz', 3",
            "'Buzz', 5",
            "'FizzBuzz', 15"
    })
    void test(String expected, int given) {
        assertEquals(expected, FizzBuzzDemo.of(given));
    }
}