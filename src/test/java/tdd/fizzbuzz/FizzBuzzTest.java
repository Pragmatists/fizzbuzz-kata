package tdd.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import tdd.fizbuzz.FizzBuzz;
import tdd.fizbuzz.FizzBuzzImpl;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.assertTrue;

public class FizzBuzzTest {
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

}
