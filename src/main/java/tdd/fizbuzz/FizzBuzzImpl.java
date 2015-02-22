package tdd.fizbuzz;

import com.google.common.base.Preconditions;

public class FizzBuzzImpl implements FizzBuzz {
    private static final String WRONG_ARGUMENT = "Argument is of illegal type!";

    @Override
    public String say(int n) {
        Preconditions.checkArgument(n > 0, WRONG_ARGUMENT);
        return "";
    }

    private boolean isDivisibleByThree(int n) {
        return n % 3 == 0;
    }

    private boolean isDivisibleByFive(int n) {
        return n % 5 == 0;
    }

    private boolean isDivisibleByThreeAndFive(int n) {
        return isDivisibleByFive(n) && isDivisibleByThree(n);
    }
}
