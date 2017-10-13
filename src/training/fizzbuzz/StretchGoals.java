package training.fizzbuzz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StretchGoals {

    public static void fizzBuzzBangWithStream() {
        FizzBuzzBangStream.create().limit(200).forEach(System.out::println);
    }

    public static void fizzFezzBuzzBangBongReverseWithOptions(int limit, List<Integer> enabledRules) {
        List<Rule> simpleRules = Arrays.asList(
                new Rule(3, "Fizz"),
                new Rule(13, "Fezz"),
                new Rule(5, "Buzz"),
                new Rule(7, "Bang"),
                new Rule(11, "Bong")
        );

        IntStream.rangeClosed(1, limit).forEach(n -> {
            Stream<String> outputs = simpleRules
                    .stream()
                    .filter(rule -> rule.matches(n) && enabledRules.contains(rule.getFactor()))
                    .map(Rule::getOutput);

            if (n % 11 == 0 && enabledRules.contains(11)) {
                outputs = outputs.filter(s -> s.equals("Fezz") || s.equals("Bong"));
            }

            List<String> outputsList = outputs.collect(Collectors.toList());

            if (n % 17 == 0 && enabledRules.contains(17)) {
                Collections.reverse(outputsList);
            }

            System.out.println(outputsList.size() > 0 ? String.join("", outputsList) : n);
        });
    }
}
