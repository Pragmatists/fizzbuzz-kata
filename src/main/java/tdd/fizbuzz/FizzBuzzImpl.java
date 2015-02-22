package tdd.fizbuzz;

import com.google.common.base.Preconditions;

public class FizzBuzzImpl implements FizzBuzz {
    private static final String WRONG_ARGUMENT = "Argument is of illegal type!";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";
    private static final String FIVE = "5";
    private static final String THREE = "3";

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

    @Override
    public String sayWhenContains(int n) {
        Preconditions.checkArgument(n > 0, WRONG_ARGUMENT);
        if (isDivisibleByThreeAndFive(n)) {
            return FIZZBUZZ;
        } else if (containsThree(n) || isDivisibleByThree(n)) {
            return FIZZ;
        } else if (containsFive(n) || isDivisibleByFive(n)) {
            return BUZZ;
        } else {
            return String.valueOf(n);
        }
    }

    @Override
    public void printUpToOneHundred() {
        for (int i = 1; i < 101; ++i) {
            String res = say(i);
            System.out.println(res);
        }
    }

    @Override
    public void printUpToOneHundredWhenContains() {
        for (int i = 1; i < 101; ++i) {
            String res = sayWhenContains(i);
            System.out.println(res);
        }
    }

    private boolean isDivisibleByThree(int n) {
        return n % 3 == 0;
    }

    private boolean isDivisibleByFive(int n) {
        return n % 5 == 0;
    }

    private boolean containsThree(int n) {
        return String.valueOf(n).contains(THREE);
    }

    private boolean containsFive(int n) {
        return String.valueOf(n).contains(FIVE);
    }

    private boolean isDivisibleByThreeAndFive(int n) {
        return isDivisibleByFive(n) && isDivisibleByThree(n);
    }
}
