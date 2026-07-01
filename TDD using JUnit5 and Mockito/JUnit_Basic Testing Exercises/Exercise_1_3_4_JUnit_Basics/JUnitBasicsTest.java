package com.junit.basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitBasicsTest {

    private Calculator calculator;

    // Exercise 4: Setup method executed before each test method
    @BeforeEach
    public void setUp() {
        System.out.println("[SETUP]: Initializing Calculator instance before test execution.");
        calculator = new Calculator();
    }

    // Exercise 4: Teardown method executed after each test method
    @AfterEach
    public void tearDown() {
        System.out.println("[TEARDOWN]: Cleaning up resources after test execution.");
        calculator = null;
    }

    // Exercise 3 & 4: Combining Assertions and AAA Pattern
    @Test
    public void testCalculatorOperations() {
        // 1. Arrange
        int a = 5;
        int b = 3;

        // 2. Act
        int sumResult = calculator.add(a, b);
        int subResult = calculator.subtract(a, b);

        // 3. Assert (Exercise 3 Assertions)
        assertEquals(8, sumResult, "5 + 3 should equal 8");
        assertTrue(sumResult > 5, "Sum result should be greater than 5");
        assertFalse(subResult < 0, "5 - 3 should not be negative");
    }

    @Test
    public void testObjectNullability() {
        // Act & Assert
        assertNull(calculator.getObjectInstance(true), "Should return null when flag is true");
        assertNotNull(calculator.getObjectInstance(false), "Should not return null when flag is false");
    }
}