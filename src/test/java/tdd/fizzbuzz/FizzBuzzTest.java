package tdd.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tdd.fizbuzz.FizzBuzz;
import tdd.fizbuzz.FizzBuzzImpl;

import java.net.MalformedURLException;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static junitparams.JUnitParamsRunner.$;
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
    @Parameters(method = "provideNumbersDivisibleByThree")
    public void shouldReturnFizzWhenNIsDividableByThree(int n) {
        fizzBuzz.say(n);
        assertEquals(FIZZ, fizzBuzz.say(n));
    }

    @Test
    @Parameters(method = "provideNumbersDivisibleByFive")
    public void shouldReturnFizzWhenNIsDividableByFive(int n) {
        fizzBuzz.say(n);
        assertEquals(BUZZ, fizzBuzz.say(n));
    }

    @Test
    @Parameters(method = "provideNumbersDivisibleByFiveAndThree")
    public void shouldReturnFizzWhenNIsDividableByFiveAndThree(int n) {
        fizzBuzz.say(n);
        assertEquals(FIZZBUZZ, fizzBuzz.say(n));
    }

    private Object[] provideNumbersDivisibleByThree() {
        return $(
                $(3),
                $(6),
                $(9),
                $(27),
                $(54),
                $(72),
                $(99)
        );
    }

    private Object[] provideNumbersDivisibleByFive() {
        return $(
                $(5),
                $(10),
                $(20),
                $(25),
                $(50),
                $(55),
                $(70)
        );
    }

    private Object[] provideNumbersDivisibleByFiveAndThree() {
        return $(
                $(15),
                $(30),
                $(45),
                $(60),
                $(75),
                $(90)
        );
    }

}
