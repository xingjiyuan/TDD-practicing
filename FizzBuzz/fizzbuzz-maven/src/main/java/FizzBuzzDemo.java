public class FizzBuzzDemo {
    public static String of(int given) {
        if (given % 3 == 0 && given % 5 == 0) {
            return "FizzBuzz";
        }
        if (given % 3 == 0) {
            return "Fizz";
        }
        if (given % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(given);
    }
}
