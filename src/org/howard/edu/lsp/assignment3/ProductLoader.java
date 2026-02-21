package org.howard.edu.lsp.assignment3;

/**
 * ProductLoader is responsible for writing a list of Product objects to a CSV file.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProductLoader {
    /**
     * Writes the given list of products to a CSV file at the specified path.
     * @param products List of Product objects to write
     * @param outputPath Path to the output CSV file
     */
    public void load(List<Product> products, String outputPath) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputPath))) {
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();
            for (Product p : products) {
                bw.write(p.toCSVRow());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }
    }
}
