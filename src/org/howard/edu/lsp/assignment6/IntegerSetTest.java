package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class IntegerSetTest {
    private IntegerSet set;
    private IntegerSet otherSet;

    @BeforeEach
    public void setUp() {
        set = new IntegerSet();
        otherSet = new IntegerSet();
    }

    @Test
    public void testAdd() {
        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertEquals(2, set.length());

        set.add(2); // duplicate
        assertEquals(2, set.length());
    }

    @Test
    public void testContains() {
        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));   // normal
        assertFalse(set.contains(99)); // edge
    }

    @Test
    public void testRemove() {
        set.add(1);
        set.add(2);
        set.remove(1);
        assertFalse(set.contains(1));
        assertTrue(set.contains(2));

        set.remove(99); // edge: value not present
        assertEquals(1, set.length());
    }

    @Test
    public void testClear() {
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());

        set.clear(); // edge: already empty
        assertTrue(set.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set.isEmpty()); // empty
        set.add(5);
        assertFalse(set.isEmpty()); // non-empty
    }

    @Test
    public void testLength() {
        assertEquals(0, set.length()); // edge
        set.add(1);
        set.add(2);
        assertEquals(2, set.length()); // normal
    }

    @Test
    public void testLargest() {
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals(3, set.largest());

        set.clear();
        set.add(42);
        assertEquals(42, set.largest());

        set.clear();
        assertThrows(NoSuchElementException.class, () -> set.largest());
    }

    @Test
    public void testSmallest() {
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals(1, set.smallest());

        set.clear();
        set.add(99);
        assertEquals(99, set.smallest());

        set.clear();
        assertThrows(NoSuchElementException.class, () -> set.smallest());
    }

    @Test
    public void testEquals() {
        set.add(1);
        set.add(2);
        otherSet.add(1);
        otherSet.add(2);
        assertTrue(set.equals(otherSet));

        set.clear();
        otherSet.clear();
        set.add(2);
        set.add(1);
        otherSet.add(1);
        otherSet.add(2);
        assertTrue(set.equals(otherSet)); // same elements, different order

        otherSet.add(3);
        assertFalse(set.equals(otherSet));

        assertFalse(set.equals(null));
    }

    @Test
    public void testUnion() {
        set.add(1);
        set.add(2);
        otherSet.add(2);
        otherSet.add(3);
        IntegerSet union = set.union(otherSet);
        assertTrue(union.contains(1));
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertEquals(3, union.length());

        IntegerSet emptySet = new IntegerSet();
        IntegerSet union2 = set.union(emptySet);
        assertTrue(union2.equals(set));
    }

    @Test
    public void testIntersect() {
        set.add(1);
        set.add(2);
        set.add(3);
        otherSet.add(2);
        otherSet.add(3);
        otherSet.add(4);
        IntegerSet intersection = set.intersect(otherSet);
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
        assertEquals(2, intersection.length());

        set.clear();
        otherSet.clear();
        set.add(1);
        set.add(2);
        otherSet.add(3);
        otherSet.add(4);
        IntegerSet intersection2 = set.intersect(otherSet);
        assertTrue(intersection2.isEmpty());
    }

    @Test
    public void testDiff() {
        set.add(1);
        set.add(2);
        set.add(3);
        otherSet.add(2);
        otherSet.add(4);
        IntegerSet diff = set.diff(otherSet);
        assertTrue(diff.contains(1));
        assertTrue(diff.contains(3));
        assertFalse(diff.contains(2));
        assertEquals(2, diff.length());

        set.clear();
        otherSet.clear();
        set.add(1);
        set.add(2);
        otherSet.add(1);
        otherSet.add(2);
        IntegerSet diff2 = set.diff(otherSet);
        assertTrue(diff2.isEmpty());
    }

    @Test
    public void testComplement() {
        set.add(1);
        set.add(2);
        otherSet.add(2);
        otherSet.add(3);
        IntegerSet complement = set.complement(otherSet);
        assertTrue(complement.contains(3));
        assertFalse(complement.contains(1));
        assertFalse(complement.contains(2));
        assertEquals(1, complement.length());

        set.clear();
        otherSet.clear();
        set.add(1);
        set.add(2);
        otherSet.add(3);
        otherSet.add(4);
        IntegerSet complement2 = set.complement(otherSet);
        assertTrue(complement2.contains(3));
        assertTrue(complement2.contains(4));
        assertEquals(2, complement2.length());
    }

    @Test
    public void testToString() {
        assertEquals("[]", set.toString());

        set.add(2);
        set.add(1);
        set.add(3);
        assertEquals("[1, 2, 3]", set.toString());
    }
}