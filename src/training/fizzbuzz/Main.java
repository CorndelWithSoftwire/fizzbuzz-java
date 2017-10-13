package training.fizzbuzz;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int limit = promptForLimit();

        List<Integer> enabledRules = calculateEnabledRules(args);

        System.out.println("Fizzing with rules: " + enabledRules.stream().map(Object::toString).collect(Collectors.joining(", ")));
        StretchGoals.fizzFezzBuzzBangBongReverseWithOptions(limit, enabledRules);
    }

    private static int promptForLimit() {
        while (true) {
            System.out.println("Please enter the number you'd like to FizzBuzz up to: ");
            String limitText = new Scanner(System.in).nextLine();

            try {
                return Integer.parseInt(limitText);
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private static List<Integer> calculateEnabledRules(String[] commandLineArguments) {
        return commandLineArguments.length == 0
                ? Arrays.asList(3, 5, 7, 11, 13, 17)
                : Stream.of(commandLineArguments).map(Integer::parseInt).collect(Collectors.toList());
    }
}
