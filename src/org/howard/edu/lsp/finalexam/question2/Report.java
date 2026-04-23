package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class for reports using the Template Method pattern.
 */
public abstract class Report {

    /**
     * Template method that defines the fixed report generation workflow.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();

        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();

        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }

    /**
     * Loads the data needed for the report.
     */
    protected abstract void loadData();

    /**
     * Formats and returns the header section of the report.
     */
    protected abstract String formatHeader();

    /**
     * Formats and returns the body section of the report.
     */
    protected abstract String formatBody();

    /**
     * Formats and returns the footer section of the report.
     */
    protected abstract String formatFooter();
}