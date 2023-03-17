package org.howard.edu.lsp.midterm.problem51;

import static org.junit.jupiter.api.Assertions.*;

import java.io.EOFException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerRangeTest {
    private Range range;

    @BeforeEach
    void setUp() {
        range = new IntegerRange(1, 10);
    }

    @Test
    void testConstructor() {
        assertEquals(1, ((IntegerRange) range).getLower());
        assertEquals(10, ((IntegerRange) range).getUpper());
    }

    @Test
    void testConstructorLowerGreaterThanUpper() {
        assertThrows(IllegalArgumentException.class, () -> new IntegerRange(10, 1));
    }

    @Test
    void testContainsTrue() {
        assertTrue(((IntegerRange) range).contains(5));
    }

    @Test
    void testContainsFalse() {
        assertFalse(((IntegerRange) range).contains(0));
    }

    @Test
    void testOverlapsTrue() throws EOFException {
        Range other = new IntegerRange(5, 15);
        try {
			assertTrue(((IntegerRange) range).overlaps(other));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    void testOverlapsFalse() throws EOFException {
        Range other = new IntegerRange(15, 20);
        try {
			assertFalse(((IntegerRange) range).overlaps(other));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    void testOverlapsEmptyRangeException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ((IntegerRange) range).overlaps(null));
        String expectedMessage = "Range object cannot be null.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



    @Test
    void testSize() {
        assertEquals(10, ((IntegerRange) range).size());
    }
}