package training.fizzbuzz;

public class Part1 {

    public static void fizzBuzz() {
        for (int n = 1; n <= 100; n++) {
            if (n % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (n % 3 == 0) {
                System.out.println("Fizz");
            } else if (n % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(n);
            }
        }
    }
}
