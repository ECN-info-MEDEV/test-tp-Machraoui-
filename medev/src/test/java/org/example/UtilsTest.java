package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    public void testConcatWords() {
        System.out.println("concatWords");
        assertEquals("Hello, world!", Utils.concatWords(new String[]{"Hello", ", ", "world", "!"}));
    }
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testComputeFactorial() {
        System.out.println("computeFactorial");
        final int factorialOf = 1 + (int) (30000 * Math.random());
        System.out.println("computing " + factorialOf + "!");
        System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
    }
    @Test
    public void checkExpectedException() {
        System.out.println("checkExpectedException");
        final int factorialOf = -5;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//code under test for throwing IllegalArgumentException
                System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf)));
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }


}