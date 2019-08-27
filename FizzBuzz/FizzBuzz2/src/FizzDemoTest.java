import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzDemoTest {
    @Test
    public void should_1_with_given_1() {
        assertEquals("1", FizzDemo.of(1));
    }

    @Test
    void should_fizz_with_given_3() {
        assertEquals("Fizz", FizzDemo.of(3));
    }

    @Test
    void should_buzz_with_given_5() {
        assertEquals("Buzz", FizzDemo.of(5));
    }

    @Test
    void should_fizzbuzz_with_given_15() {
        assertEquals("FizzBuzz", FizzDemo.of(15));
    }
}