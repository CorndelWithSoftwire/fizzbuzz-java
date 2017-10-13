package training.fizzbuzz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Part2 {

    public static void fizzBuzzBang() {
        for (int n = 1; n <= 200; n++) {
            StringBuilder stringBuilder = new StringBuilder();

            if (n % 3 == 0) {
                stringBuilder.append("Fizz");
            }

            if (n % 5 == 0) {
                stringBuilder.append("Buzz");
            }

            if (n % 7 == 0) {
                stringBuilder.append("Bang");
            }

            System.out.println(stringBuilder.length() == 0 ? n : stringBuilder.toString());
        }
    }

    public static void fizzBuzzBangCollections() {
        List<Rule> rules = Arrays.asList(
                new Rule(3, "Fizz"),
                new Rule(5, "Buzz"),
                new Rule(7, "Bang")
        );

        IntStream.rangeClosed(1, 200).forEach(n -> {
                    String output = rules.stream().filter(rule -> rule.matches(n)).map(Rule::getOutput).collect(Collectors.joining());
                    System.out.println(output.length() > 0 ? output : n);
                }
        );
    }

    public static void fizzBuzzBangBong() {
        for (int n = 1; n <= 200; n++) {
            StringBuilder stringBuilder = new StringBuilder();

            if (n % 3 == 0) {
                stringBuilder.append("Fizz");
            }

            if (n % 5 == 0) {
                stringBuilder.append("Buzz");
            }

            if (n % 7 == 0) {
                stringBuilder.append("Bang");
            }

            if (n % 11 == 0) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append("Bong");
            }

            System.out.println(stringBuilder.length() == 0 ? n : stringBuilder.toString());
        }
    }

    public static void fizzFezzBuzzBangBong() {
        for (int n = 1; n <= 200; n++) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean fezz = false;

            if (n % 3 == 0) {
                stringBuilder.append("Fizz");
            }

            if (n % 13 == 0) {
                stringBuilder.append("Fezz");
                fezz = true;
            }

            if (n % 5 == 0) {
                stringBuilder.append("Buzz");
            }

            if (n % 7 == 0) {
                stringBuilder.append("Bang");
            }

            if (n % 11 == 0) {
                stringBuilder.delete(0, stringBuilder.length());
                if (fezz) {
                    stringBuilder.append("Fezz");
                }
                stringBuilder.append("Bong");
            }

            System.out.println(stringBuilder.length() == 0 ? n : stringBuilder.toString());
        }
    }

    public static void fizzFezzBuzzBangBongCollections() {
        List<Rule> simpleRules = Arrays.asList(
                new Rule(3, "Fizz"),
                new Rule(13, "Fezz"),
                new Rule(5, "Buzz"),
                new Rule(7, "Bang"),
                new Rule(11, "Bong")
        );

        IntStream.rangeClosed(1, 200).forEach(n -> {
            Stream<String> outputs = simpleRules.stream().filter(rule -> rule.matches(n)).map(Rule::getOutput);

            if (n % 11 == 0) {
                outputs = outputs.filter(s -> s.equals("Fezz") || s.equals("Bong"));
            }

            String output = outputs.collect(Collectors.joining());

            System.out.println(output.length() > 0 ? output : n);
        });
    }

    public static void fizzFezzBuzzBangBongReverse() {
        List<Rule> simpleRules = Arrays.asList(
                new Rule(3, "Fizz"),
                new Rule(13, "Fezz"),
                new Rule(5, "Buzz"),
                new Rule(7, "Bang"),
                new Rule(11, "Bong")
        );

        IntStream.rangeClosed(1, 300).forEach(n -> {
            Stream<String> outputs = simpleRules.stream().filter(rule -> rule.matches(n)).map(Rule::getOutput);

            if (n % 11 == 0) {
                outputs = outputs.filter(s -> s.equals("Fezz") || s.equals("Bong"));
            }

            List<String> outputsList = outputs.collect(Collectors.toList());

            if (n % 17 == 0) {
                Collections.reverse(outputsList);
            }

            System.out.println(outputsList.size() > 0 ? String.join("", outputsList) : n);
        });
    }
}
