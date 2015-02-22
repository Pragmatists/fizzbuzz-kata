package tdd.fizbuzz;

import com.google.common.base.Preconditions;

public class FizzBuzzImpl implements FizzBuzz {
    private static final String WRONG_ARGUMENT = "Argument is of illegal type!";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    @Override
    public String say(int n) {
        Preconditions.checkArgument(n > 0, WRONG_ARGUMENT);
        if (isDivisibleByThreeAndFive(n)) {
            return FIZZBUZZ;
        } else if (isDivisibleByThree(n)) {
            return FIZZ;
        } else if (isDivisibleByFive(n)) {
            return BUZZ;
        } else {
            return String.valueOf(n);
        }
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
