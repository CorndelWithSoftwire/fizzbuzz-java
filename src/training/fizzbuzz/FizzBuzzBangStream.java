package training.fizzbuzz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FizzBuzzBangStream {

    private static List<Rule> rules = Arrays.asList(
            new Rule(3, "Fizz"),
            new Rule(5, "Buzz"),
            new Rule(7, "Bang")
    );

    public static Stream<String> create() {
        Iterator<String> iterator = new Iterator<String>() {
            private int n = 1;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                String rulesOutput = rules.stream().filter(rule -> rule.matches(n)).map(Rule::getOutput).collect(Collectors.joining());
                String result = rulesOutput.length() > 0 ? rulesOutput : Integer.toString(n);
                n = n + 1;
                return result;
            }
        };

        int characteristics = Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL;
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(iterator, characteristics);

        return StreamSupport.stream(spliterator, false);
    }
}
