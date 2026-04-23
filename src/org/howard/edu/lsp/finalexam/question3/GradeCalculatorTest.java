package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for the GradeCalculator class.
 */
public class GradeCalculatorTest {

    @Test
    public void testAverage() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(85.0, calculator.average(80, 85, 90));
    }

    @Test
    public void testLetterGrade() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("A", calculator.letterGrade(95));
        assertEquals("B", calculator.letterGrade(85));
        assertEquals("C", calculator.letterGrade(75));
        assertEquals("D", calculator.letterGrade(65));
        assertEquals("F", calculator.letterGrade(55));
    }

    @Test
    public void testIsPassing() {
        GradeCalculator calculator = new GradeCalculator();
        assertTrue(calculator.isPassing(60));
        assertFalse(calculator.isPassing(59.9));
    }

    @Test
    public void testAverageBoundaryMinimumScore() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(0.0, calculator.average(0, 0, 0));
    }

    @Test
    public void testAverageBoundaryMaximumScore() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(100.0, calculator.average(100, 100, 100));
    }

    @Test
    public void testAverageThrowsExceptionForNegativeScore() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 90);
        });
    }

    @Test
    public void testAverageThrowsExceptionForScoreAboveOneHundred() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 90);
        });
    }
}