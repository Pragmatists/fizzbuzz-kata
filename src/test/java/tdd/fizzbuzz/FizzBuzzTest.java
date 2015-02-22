package tdd.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import tdd.fizbuzz.FizzBuzz;
import tdd.fizbuzz.FizzBuzzImpl;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";
    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzzImpl();
    }

    @Test
    public void shouldThrowExceptionWhenNIsLessThanZero() {
        catchException(fizzBuzz).say(-1);
        assertTrue(caughtException() instanceof IllegalArgumentException);
    }

    @Test
    public void shouldThrowExceptionWhenCheckingForContainsAndNIsLessThanZero() {
        catchException(fizzBuzz).sayWhenContains(-1);
        assertTrue(caughtException() instanceof IllegalArgumentException);
    }

    @Test
    @Parameters({"3", "6", "9", "27", "54", "72", "99" })
    public void shouldReturnFizzWhenNIsDivisibleByThree(int n) {
        assertEquals(FIZZ, fizzBuzz.say(n));
    }

    @Test
    @Parameters({"5", "10", "20", "25", "55", "50", "70" })
    public void shouldReturnFizzWhenNIsDivisibleByFive(int n) {
        assertEquals(BUZZ, fizzBuzz.say(n));
    }

    @Test
    @Parameters({"15", "30", "45", "60", "75", "90" })
    public void shouldReturnFizzWhenNIsDivisibleByFiveAndThree(int n) {
        assertEquals(FIZZBUZZ, fizzBuzz.say(n));
    }

    @Test
    @Parameters({"2", "4"})
    public void shouldSayThatNumber(int n) {
        assertEquals(String.valueOf(n), fizzBuzz.say(n));
    }

    @Test
    @Parameters({"2", "4"})
    public void shouldSayThatNumberWithWhenContains(int n) {
        assertEquals(String.valueOf(n), fizzBuzz.sayWhenContains(n));
    }

    @Test
    @Parameters({"52", "59", "56"})
    public void shouldReturnFizzWhenNIsDivisibleByFiveAndContainsThatDigit(int n) {
        assertEquals(BUZZ, fizzBuzz.sayWhenContains(n));
    }

    @Test
    @Parameters({"3", "6", "9", "27", "31", "39", "53" })
    public void shouldReturnFizzWhenNIsDivisibleByThreeAndContainsThatDigit(int n) {
        assertEquals(FIZZ, fizzBuzz.sayWhenContains(n));
    }

    @Test
    @Ignore
    public void shouldPrintUpToOneHundred() {
        fizzBuzz.printUpToOneHundred();
    }

    @Test
    @Ignore
    public void shouldPrintUpToOneHundredWhenContains() {
        fizzBuzz.printUpToOneHundredWhenContains();
    }

}
