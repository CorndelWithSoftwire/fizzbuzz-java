package training.fizzbuzz;

public class Rule {

    private final int factor;
    private final String output;

    public Rule(int factor, String output) {
        this.factor = factor;
        this.output = output;
    }

    public boolean matches(int n) {
        return n % factor == 0;
    }

    public int getFactor() {
        return factor;
    }

    public String getOutput() {
        return output;
    }
}
