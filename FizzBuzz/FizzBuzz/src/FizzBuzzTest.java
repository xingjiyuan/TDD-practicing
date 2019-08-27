import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
    private void assertFizzBuzz(String expected, int value) {
        assertEquals(expected, FizzBuzz.function(value));
    }

    @Test
    public void test_common_value() {
        assertFizzBuzz("1", 1);
    }

    @Test
    public void test_multiple_3_value() {
        assertFizzBuzz("Fizz", 3);
        assertFizzBuzz("Fizz", 6);
        assertFizzBuzz("Fizz", 9);
    }

    @Test
    public void test_multiple_5_value() {
        assertFizzBuzz("Buzz", 5);
        assertFizzBuzz("Buzz", 10);
    }

    @Test
    public void test_multiple_5_and_3_value() {
        assertFizzBuzz("FizzBuzz", 15);
    }

    @Test
    public void test_within_3_value() {
        assertFizzBuzz("Fizz", 13);
    }

    @Test
    public void test_within_5_value() {
        assertFizzBuzz("Buzz", 52);
    }
}