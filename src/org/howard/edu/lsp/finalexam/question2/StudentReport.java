package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete implementation of Report for student data.
 * Provides specific formatting for student reports.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    /**
     * Loads student data into the report.
     * In this example, values are assigned directly.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Formats the header section of the student report.
     *
     * @return formatted student report header
     */
    @Override
    protected String formatHeader() {
        return "Student Report";
    }

    /**
     * Formats the body section of the student report.
     *
     * @return formatted student report body
     */
    @Override
    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    /**
     * Formats the footer section of the student report.
     *
     * @return formatted student report footer
     */
    @Override
    protected String formatFooter() {
        return "End of Student Report";
    }
}