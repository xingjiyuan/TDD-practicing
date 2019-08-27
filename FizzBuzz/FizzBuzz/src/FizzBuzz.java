public class FizzBuzz {
    public static void main(String[] args){
        for (int i = 1; i < 100; i++) {
            System.out.println(function(i));
        }
    }

    public static String function(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        if (isFizz(i)) {
            return "Fizz";
        }
        if (isBuzz(i)) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

    private static boolean isBuzz(int i) {
        return i % 5 == 0 || String.valueOf(i).indexOf('5')!=-1;
    }

    private static boolean isFizz(int i) {
        return i % 3 == 0|| String.valueOf(i).indexOf('3')!=-1;
    }
}
