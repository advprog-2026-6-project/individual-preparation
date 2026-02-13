package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VectorUtilityTest {

    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = new VectorUtility();
    }

    // --- add() tests ---
    @Test
    void testAddVectors() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        double[] expected = {5.0, 7.0, 9.0};
        assertArrayEquals(expected, vectorUtility.add(v1, v2));
    }

    @Test
    void testAddVectorsDimensionMismatch() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertThrows(IllegalArgumentException.class,
            () -> vectorUtility.add(v1, v2));
    }

    @Test
    void testAddZeroVectors() {
        double[] v1 = {0.0, 0.0, 0.0};
        double[] v2 = {1.0, 2.0, 3.0};
        double[] expected = {1.0, 2.0, 3.0};
        assertArrayEquals(expected, vectorUtility.add(v1, v2));
    }

    // --- subtract() tests ---
    @Test
    void testSubtractVectors() {
        double[] v1 = {4.0, 5.0, 6.0};
        double[] v2 = {1.0, 2.0, 3.0};
        double[] expected = {3.0, 3.0, 3.0};
        assertArrayEquals(expected, vectorUtility.subtract(v1, v2));
    }

    @Test
    void testSubtractVectorsDimensionMismatch() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertThrows(IllegalArgumentException.class,
            () -> vectorUtility.subtract(v1, v2));
    }

    @Test
    void testSubtractSameVectors() {
        double[] v1 = {3.0, 4.0, 5.0};
        double[] v2 = {3.0, 4.0, 5.0};
        double[] expected = {0.0, 0.0, 0.0};
        assertArrayEquals(expected, vectorUtility.subtract(v1, v2));
    }

    // --- multiply() tests ---
    @Test
    void testMultiplyByScalar() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] expected = {3.0, 6.0, 9.0};
        assertArrayEquals(expected, vectorUtility.multiply(v1, 3));
    }

    @Test
    void testMultiplyByZero() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] expected = {0.0, 0.0, 0.0};
        assertArrayEquals(expected, vectorUtility.multiply(v1, 0));
    }

    // --- dotProduct() tests ---
    // Note: dotProduct() is currently a TODO stub returning 0.0
    @Test
    void testDotProduct() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        double result = vectorUtility.dotProduct(v1, v2);
        assertEquals(32.0, result);
    }

    @Test
    void testDotProductOrthogonal() {
        double[] v1 = {1.0, 0.0};
        double[] v2 = {0.0, 1.0};
        assertEquals(0.0, vectorUtility.dotProduct(v1, v2));
    }

    // --- norm() tests ---
    @Test
    void testNorm() {
        double[] v1 = {3.0, 4.0};
        double[] expected = {0.6, 0.8};
        assertArrayEquals(expected, vectorUtility.norm(v1), 0.0001);
    }

    @Test
    void testNormZeroVector() {
        double[] v1 = {0.0, 0.0, 0.0};
        double[] expected = {0.0, 0.0, 0.0};
        assertArrayEquals(expected, vectorUtility.norm(v1));
    }

    @Test
    void testNormUnitVector() {
        double[] v1 = {1.0, 0.0, 0.0};
        double[] expected = {1.0, 0.0, 0.0};
        assertArrayEquals(expected, vectorUtility.norm(v1));
    }
}
