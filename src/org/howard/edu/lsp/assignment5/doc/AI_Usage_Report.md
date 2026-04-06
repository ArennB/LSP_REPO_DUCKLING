# AI Usage Report

---

## Phase 1 — Understanding the Assignment
**Myself:**
I’m starting Assignment 5 where I need to implement an IntegerSet class using an ArrayList. Can you explain what the assignment means by a mathematical set?
**ChatGPT:**
A mathematical set is a collection of unique elements, meaning duplicates are not allowed. In Java, when using an ArrayList, you must manually prevent duplicates by checking whether the value already exists before adding it.
Example:
if (!set.contains(item)) {
    set.add(item);
}
This ensures your structure behaves like a true mathematical set.
**Myself:**
Should I use ArrayList<Integer> or List<Integer> for the variable?
**ChatGPT:**
Use:
private List<Integer> set = new ArrayList<>();
This follows good object-oriented practice by programming to the interface (List) instead of the implementation.

## Phase 2 — Planning Required Methods
**Myself:**
Can you help me list all the methods I need to implement?
**ChatGPT:**
Yes. The required methods are:
public void clear()
public int length()
public boolean equals(IntegerSet b)
public boolean contains(int value)
public int largest()
public int smallest()
public void add(int item)
public void remove(int item)
public IntegerSet union(IntegerSet intSetb)
public IntegerSet intersect(IntegerSet intSetb)
public IntegerSet diff(IntegerSet intSetb)
public IntegerSet complement(IntegerSet intSetb)
public boolean isEmpty()
public String toString()
I suggested implementing simpler methods first before moving to set operations.

## Phase 3 — Implementing Core Methods
**Myself:**
How should I implement clear()?
**ChatGPT:**
Use:
public void clear() {
    set.clear();
}
**Myself:**
How should I implement length()?
**ChatGPT:**
public int length() {
    return set.size();
}
**Myself:**
How do I prevent duplicates in add()?
**ChatGPT:**
public void add(int item) {
    if (!set.contains(item)) {
        set.add(item);
    }
}

## Phase 4 — Finding Largest and Smallest Values
**Myself:**
How should I implement largest() and smallest()?
**ChatGPT:**
Use the Collections class:
public int largest() {
    if (set.isEmpty()) {
        throw new NoSuchElementException("Set is empty");
    }
    return Collections.max(set);
}

public int smallest() {
    if (set.isEmpty()) {
        throw new NoSuchElementException("Set is empty");
    }
    return Collections.min(set);
}
This also ensures proper handling of empty sets.

## Phase 5 — Implementing Set Operations
**Myself:**
How should I implement the union() method?
**ChatGPT:**
Create a new set and copy elements from both sets:
public IntegerSet union(IntegerSet b) {
    IntegerSet result = new IntegerSet();

    for (int value : this.set) {
        result.add(value);
    }

    for (int value : b.set) {
        result.add(value);
    }

    return result;
}
This ensures original sets remain unchanged.
**Myself:**
How is intersect() different?
**ChatGPT:**
Intersection includes only elements that exist in both sets:
public IntegerSet intersect(IntegerSet b) {
    IntegerSet result = new IntegerSet();

    for (int value : this.set) {
        if (b.contains(value)) {
            result.add(value);
        }
    }

    return result;
}
**Myself:**
How do I implement diff() and complement()?
**ChatGPT:**
Difference:
public IntegerSet diff(IntegerSet b) {
    IntegerSet result = new IntegerSet();

    for (int value : this.set) {
        if (!b.contains(value)) {
            result.add(value);
        }
    }

    return result;
}
Complement:
public IntegerSet complement(IntegerSet b) {
    IntegerSet result = new IntegerSet();

    for (int value : b.set) {
        if (!this.contains(value)) {
            result.add(value);
        }
    }

    return result;
}

## Phase 6 — Implementing equals() and toString()
**Myself:**
How do I compare sets if order doesn't matter?
**ChatGPT:**
Use containsAll() in both directions:
public boolean equals(IntegerSet b) {
    if (b == null) {
        return false;
    }

    return this.set.containsAll(b.set)
        && b.set.containsAll(this.set);
}
**Myself:**
The assignment says output must be sorted in toString(). How should I do that?
**ChatGPT:**
@Override
public String toString() {
    if (set.isEmpty()) {
        return "[]";
    }

    List<Integer> sorted = new ArrayList<>(set);
    Collections.sort(sorted);

    return sorted.toString();
}

## Phase 7 — Debugging Implementation
**Myself:**
Here is my implementation. Can you check if there are any errors?
(Code reviewed.)
**ChatGPT:**
Your implementation was mostly correct, but the remove(int item) method contained an issue.
Original:
set.remove(item);
This removes by index instead of value.
Corrected version:
set.remove(Integer.valueOf(item));
This ensures the correct element is removed.

## Phase 8 — Verifying Program Output
**Myself:**
Here is my program output. Does this look correct?
(Output included union, intersection, diff, complement, largest, smallest, remove, and clear results.)
**ChatGPT:**
Yes. The output confirms:
remove() works correctly
Set operations return correct values
Original sets remain unchanged
Sorting and formatting are correct
All required methods appear to function as expected