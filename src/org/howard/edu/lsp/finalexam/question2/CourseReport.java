package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete implementation of Report for course data.
 * Provides specific formatting for course reports.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    /**
     * Loads course data into the report.
     * In this example, values are assigned directly.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Formats the header section of the course report.
     *
     * @return formatted course report header
     */
    @Override
    protected String formatHeader() {
        return "Course Report";
    }

    /**
     * Formats the body section of the course report.
     *
     * @return formatted course report body
     */
    @Override
    protected String formatBody() {
        return "Course: " + courseName + "\nEnrollment: " + enrollment;
    }

    /**
     * Formats the footer section of the course report.
     *
     * @return formatted course report footer
     */
    @Override
    protected String formatFooter() {
        return "End of Course Report";
    }
}