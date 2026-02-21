package org.howard.edu.lsp.assignment3;

/**
 * ProductExtractor is responsible for reading product data from a CSV file and parsing it into Product objects.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductExtractor {
    /**
     * Extracts products from a CSV file.
     * @param inputPath Path to the input CSV file
     * @param summary Array to store [rowsRead, rowsSkipped]
     * @return List of valid Product objects
     */
    public List<Product> extract(String inputPath, int[] summary) {
        List<Product> products = new ArrayList<>();
        int rowsRead = 0, rowsSkipped = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputPath))) {
            String line;
            boolean isFirst = true;
            while ((line = br.readLine()) != null) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                rowsRead++;
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }
                try {
                    Product p = Product.fromCSV(fields);
                    products.add(p);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            summary[0] = -1; // error
            return products;
        }
        summary[0] = rowsRead;
        summary[1] = rowsSkipped;
        return products;
    }
}
