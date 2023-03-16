package org.howard.edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
	private IntegerSet set;

@BeforeEach
void setUp() {
     set = new IntegerSet();
}

@Test
@DisplayName("Test case for clear")
void testClear() {
    set.add(1);
    set.add(2);
    set.add(3);
    set.clear();
    Assertions.assertTrue(set.isEmpty());
}

@Test
@DisplayName("Test case for length")
void testLength() {
    set.add(1);
    set.add(2);
    set.add(3);
    Assertions.assertEquals(3, set.length());
}

@Test
@DisplayName("Test case for equals")
void testEquals() {
    IntegerSet set2 = new IntegerSet();
    set.add(1);
    set.add(2);
    set.add(3);
    set2.add(2);
    set2.add(1);
    set2.add(3);
    Assertions.assertTrue(set.equals(set2));
}

@Test
@DisplayName("Test case for contains")
void testContains() {
    set.add(1);
    set.add(2);
    set.add(3);
    Assertions.assertTrue(set.contains(2));
    Assertions.assertFalse(set.contains(4));
}

@Test
@DisplayName("Test case for largest")
void testLargest() {
    set.add(1);
    set.add(2);
    set.add(3);
    try {
		Assertions.assertEquals(3, set.largest());
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    set.clear();
//    Assertions.assertThrows(IntegerSetException.class, () -> set.largest());
}

@Test
@DisplayName("Test case for smallest")
void testSmallest() {
    set.add(1);
    set.add(2);
    set.add(3);
    try {
		Assertions.assertEquals(1, set.smallest());
	} catch (IntegerSetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    set.clear();
    Assertions.assertThrows(IntegerSetException.class, () -> set.smallest());
}

@Test
@DisplayName("Test case for add")
void testAdd() {
    set.add(1);
    set.add(2);
    set.add(3);
    Assertions.assertEquals(3, set.length());
    set.add(3);
    Assertions.assertEquals(3, set.length());
}

@Test
@DisplayName("Test case for remove")
void testRemove() {
    set.add(1);
    set.add(2);
    set.add(3);
    set.remove(2);
    Assertions.assertFalse(set.contains(2));
    Assertions.assertEquals(2, set.length());
    set.remove(4);
    Assertions.assertEquals(2, set.length());
}

@Test
@DisplayName("Test case for union")
void testUnion() {
    IntegerSet set2 = new IntegerSet();
    set.add(1);
    set.add(2);
    set2.add(2);
    set2.add(3);
    set.union(set2);
    Assertions.assertEquals(3, set.length());
    Assertions.assertTrue(set.contains(1));
    Assertions.assertTrue(set.contains(2));
    Assertions.assertTrue(set.contains(3));
}


@Test
@DisplayName("Test case for intersect")
void testIntersect() {
    IntegerSet set2 = new IntegerSet();
    set.add(1);
    set.add(2);
    set.add(3);
    set2.add(2);
    set2.add(3);
    set2.add(4);
    set.intersect(set2);
    Assertions.assertEquals(2, set.length());
    Assertions.assertFalse(set.contains(1));
    Assertions.assertTrue(set.contains(2));
    Assertions.assertTrue(set.contains(3));
    Assertions.assertFalse(set.contains(4));
}

@Test
@DisplayName("Test case for toString")
void testToString() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    set.add(2);
    set.add(3);
    String expectedString = "[1, 2, 3]";
    Assertions.assertEquals(expectedString, set.toString());
}

@Test
@DisplayName("Test case for isEmpty")
void testIsEmpty() {
    IntegerSet set = new IntegerSet();
    Assertions.assertTrue(set.isEmpty());

    set.add(1);
    Assertions.assertFalse(set.isEmpty());

    set.clear();
    Assertions.assertTrue(set.isEmpty());
}

@Test
@DisplayName("Test case for largest with empty set")
void testLargestWithEmptySet() {
    IntegerSet set = new IntegerSet();
    Assertions.assertThrows(IntegerSetException.class, () -> set.largest());
}

@Test
@DisplayName("Test case for smallest with empty set")
void testSmallestWithEmptySet() {
    IntegerSet set = new IntegerSet();
    Assertions.assertThrows(IntegerSetException.class, () -> set.smallest());
}
@Test
@DisplayName("Test case for diff")
void testDiff() {
    IntegerSet set1 = new IntegerSet();
    set1.add(1);
    set1.add(2);
    set1.add(3);

    IntegerSet set2 = new IntegerSet();
    set2.add(2);
    set2.add(3);
    set2.add(4);

    set1.diff(set2);

    Assertions.assertEquals(1, set1.length());
    Assertions.assertTrue(set1.contains(1));
    Assertions.assertFalse(set1.contains(2));
    Assertions.assertFalse(set1.contains(3));
    Assertions.assertFalse(set1.contains(4));
}

}