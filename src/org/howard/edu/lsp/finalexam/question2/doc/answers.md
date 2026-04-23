# answers.md

Design Explanation:

The Template Method pattern is used in the Report class through the generateReport() method, which defines the fixed workflow for creating a report. The methods loadData(), formatHeader(), formatBody(), and formatFooter() are abstract methods that are implemented differently by StudentReport and CourseReport. This allows each report type to customize its own data and formatting while still following the same overall report generation process. In the Driver class, a List<Report> is used to demonstrate polymorphism by storing both StudentReport and CourseReport objects and calling generateReport() on each one.
