# AI Conversation Log — Assignment 6 (JUnit Testing)

Student Name: Arenn Banks  
Assignment 6 — IntegerSet JUnit Testing  

---

## Session 1 — Understanding the Assignment Requirements

**Student Prompt:**  
I just uploaded my Assignment 6 instructions. Can you help me understand what this assignment is asking me to do?

**AI Response Summary:**  
Explained that Assignment 6 requires copying the IntegerSet.java file from Assignment 5 into the Assignment 6 package and writing JUnit 5 test cases for every method. Clarified that each method must include both normal and edge test cases. Listed required edge cases such as duplicate values in add(), removing values not present, union with empty sets, intersection with no common elements, and exception testing for largest() and smallest().

**How It Helped:**  
Helped me understand the full scope of testing requirements and what edge cases needed to be included.

---

## Session 2 — Planning Test Cases

**Student Prompt:**  
Here is my Assignment 5 IntegerSet.java file. Can you help me figure out what test cases I need for each method?

**AI Response Summary:**  
Reviewed the IntegerSet methods and suggested test scenarios for each function. Provided examples of normal and edge cases for methods including:
- add()
- remove()
- contains()
- union()
- intersect()
- diff()
- complement()
- largest()
- smallest()
- toString()

Suggested using JUnit assertions such as:
- assertEquals()
- assertTrue()
- assertFalse()
- assertThrows()

**How It Helped:**  
Helped me organize test cases method-by-method and ensure coverage of both normal and edge cases.

---

## Session 3 — Writing Initial JUnit Tests

**Student Prompt:**  
Can you generate a basic structure for IntegerSetTest using JUnit 5?

**AI Response Summary:**  
Provided a sample test class structure including:
- @BeforeEach setup method
- Basic test methods for core functionality
- Examples of assertions
- Exception handling tests using assertThrows()

**How It Helped:**  
Provided a starting framework that I expanded and modified to match my implementation.

---

## Session 4 — Reviewing My Existing Tests

**Student Prompt:**  
Here is my current IntegerSetTest.java file. Can you check if it covers everything required in the rubric?

**AI Response Summary:**  
Reviewed the test file and compared it against the rubric requirements. Identified that most required methods were already covered. Suggested improvements such as:
- Making sure contains() has both present and absent cases
- Verifying edge cases for union, intersect, diff, and complement
- Confirming exception handling for largest() and smallest()

**How It Helped:**  
Helped confirm that my tests aligned with assignment expectations and minimized the chance of missing required edge cases.

---

## Session 5 — Final Validation Before Submission

**Student Prompt:**  
Here is my Assignment 6 IntegerSet.java file. Can you verify that my tests match the behavior of my implementation?

**AI Response Summary:**  
Reviewed both IntegerSet.java and IntegerSetTest.java. Confirmed that:
- Duplicate values are prevented in add()
- Exceptions are thrown correctly in largest() and smallest()
- Set operations return new sets
- toString() outputs values in sorted order

Confirmed that the tests aligned correctly with the implemented behavior.

**How It Helped:**  
Helped ensure consistency between implementation and test cases before final submission.