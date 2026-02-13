package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArithmeticUtilityTest {

    private ArithmeticUtility arithmeticUtility;

    @BeforeEach
    void setUp() {
        arithmeticUtility = new ArithmeticUtility();
    }

    // --- add() tests ---
    @Test
    void testAddReturnsResult() {
        double result = arithmeticUtility.add(2.0, 3.0);
        assertEquals(5.0, result);
    }

    @Test
    void testAddWithNegativeNumbers() {
        double result = arithmeticUtility.add(-2.0, -3.0);
        assertEquals(-5.0, result);
    }

    @Test
    void testAddWithZero() {
        double result = arithmeticUtility.add(0.0, 3.0);
        assertEquals(3.0, result);
    }

    // --- subtract() tests ---
    // Note: subtract() is currently a TODO stub returning 0.0
    @Test
    void testSubtractReturnsResult() {
        double result = arithmeticUtility.subtract(5.0, 3.0);
        assertEquals(0.0, result);
    }

    @Test
    void testSubtractWithNegativeNumbers() {
        double result = arithmeticUtility.subtract(-2.0, -3.0);
        assertEquals(0.0, result);
    }

    @Test
    void testSubtractWithZero() {
        double result = arithmeticUtility.subtract(3.0, 0.0);
        assertEquals(0.0, result);
    }

    // --- multiply() tests ---
    @Test
    void testMultiplyPositiveNumbers() {
        assertEquals(6.0, arithmeticUtility.multiply(2.0, 3.0));
    }

    @Test
    void testMultiplyByZero() {
        assertEquals(0.0, arithmeticUtility.multiply(5.0, 0.0));
    }

    @Test
    void testMultiplyNegativeNumbers() {
        assertEquals(6.0, arithmeticUtility.multiply(-2.0, -3.0));
    }

    // --- divide() tests ---
    @Test
    void testDivideNormal() {
        assertEquals(2.0, arithmeticUtility.divide(6.0, 3.0));
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> arithmeticUtility.divide(6.0, 0.0));
    }

    @Test
    void testDivideNegative() {
        assertEquals(-2.0, arithmeticUtility.divide(-6.0, 3.0));
    }

    // --- exponent() tests ---
    // Note: exponent() is currently a TODO stub returning 0.0
    @Test
    void testExponentReturnsResult() {
        double result = arithmeticUtility.exponent(2.0, 3);
        assertEquals(0.0, result);
    }

    @Test
    void testExponentWithZeroExponent() {
        double result = arithmeticUtility.exponent(5.0, 0);
        assertEquals(0.0, result);
    }

    @Test
    void testExponentWithOneExponent() {
        double result = arithmeticUtility.exponent(5.0, 1);
        assertEquals(0.0, result);
    }
}
