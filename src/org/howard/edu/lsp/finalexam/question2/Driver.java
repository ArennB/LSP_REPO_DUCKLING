package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class to demonstrate polymorphism
 * using the Template Method pattern.
 */
public class Driver {

    public static void main(String[] args) {

        // Create list of reports
        List<Report> reports = new ArrayList<>();

        // Add different report types
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        // Loop through reports and generate them
        for (Report report : reports) {
            report.generateReport();
        }
    }
}