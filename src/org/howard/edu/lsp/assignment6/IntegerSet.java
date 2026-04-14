package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class that represents a mathematical set of integers.
 * Duplicate values are not allowed.
 *
 * Supports common set operations such as union, intersection,
 * difference, and complement.
 *
 * @author Arenn Banks
 */
public class IntegerSet {
    /**
     * Internal list used to store unique integer values.
     */
    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor that creates an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks whether the set is empty.
     *
     * @return true if the set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Checks whether the set contains a given value.
     *
     * @param value the value to search for
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified item from the set if it exists.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return the smallest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Compares this set with another set for equality.
     * Two sets are equal if they contain exactly the same elements,
     * regardless of order.
     *
     * @param b the other IntegerSet to compare with
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        return this.set.containsAll(b.set) && b.set.containsAll(this.set);
    }

    /**
     * Returns a new set that is the union of this set and another set.
     * The result contains all elements that appear in either set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int value : this.set) {
            result.add(value);
        }

        for (int value : intSetb.set) {
            result.add(value);
        }

        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and another set.
     * The result contains only elements common to both sets.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int value : this.set) {
            if (intSetb.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements that are in this set
     * but not in the other set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int value : this.set) {
            if (!intSetb.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements that are in the other set
     * but not in this set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int value : intSetb.set) {
            if (!this.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format example: [1, 2, 3]
     *
     * @return the string representation of the set
     */
    @Override
    public String toString() {
        if (set.isEmpty()) {
            return "[]";
        }

        List<Integer> sortedSet = new ArrayList<>(set);
        Collections.sort(sortedSet);

        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < sortedSet.size(); i++) {
            result.append(sortedSet.get(i));
            if (i < sortedSet.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }
}
