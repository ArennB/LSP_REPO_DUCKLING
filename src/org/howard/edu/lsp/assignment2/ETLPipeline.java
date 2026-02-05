/**
 * Name: Arenn Banks
 */

package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
	public static void main(String[] args) {
		String inputPath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";
		List<String[]> records = new ArrayList<>();
		String header = null;
		int skippedRows = 0;
		int processedRows = 0;
		int rowsRead = 0;
		// Extract
		try (BufferedReader br = Files.newBufferedReader(Paths.get(inputPath))) {
			String line;
			boolean isFirst = true;
			while ((line = br.readLine()) != null) {
				if (isFirst) {
					header = line;
					isFirst = false;
					continue;
				}
				rowsRead++;
				if (line.trim().isEmpty()) {
					skippedRows++;
					continue;
				}
				String[] fields = line.split(",");
				if (fields.length != 4) {
					skippedRows++;
					continue;
				}
				String productId = fields[0].trim();
				String priceStr = fields[2].trim();
				try {
					Integer.parseInt(productId);
					new BigDecimal(priceStr);
				} catch (NumberFormatException e) {
					skippedRows++;
					continue;
				}
				records.add(fields);
			}
		} catch (IOException e) {
			System.err.println("Error reading input file: " + e.getMessage());
			return;
		}

		List<String[]> transformed = new ArrayList<>();
		// Transform
		for (String[] rec : records) {
			// ...existing code...
			String productId = rec[0].trim();
			String name = rec[1].trim().toUpperCase();
			String priceStr = rec[2].trim();
			String category = rec[3].trim();
			String origCategory = category;
			BigDecimal price;
			try {
				price = new BigDecimal(priceStr);
			} catch (NumberFormatException e) {
				// Should not happen due to earlier check
				continue;
			}
			if (category.equalsIgnoreCase("Electronics")) {
				price = price.multiply(new BigDecimal("0.9"));
			}
			price = price.setScale(2, RoundingMode.HALF_UP);
			if (price.compareTo(new BigDecimal("500.00")) > 0 && origCategory.equalsIgnoreCase("Electronics")) {
				category = "Premium Electronics";
			}
			String priceRange;
			if (price.compareTo(new BigDecimal("10.00")) <= 0) {
				priceRange = "Low";
			} else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
				priceRange = "Medium";
			} else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
				priceRange = "High";
			} else {
				priceRange = "Premium";
			}
			transformed.add(new String[] {
				productId, name, price.toPlainString(), category, priceRange
			});
			processedRows++;
		}

		// Load
		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputPath))) {
			bw.write("ProductID,Name,Price,Category,PriceRange");
			bw.newLine();
			for (String[] rec : transformed) {
				bw.write(String.join(",", rec));
				bw.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error writing output file: " + e.getMessage());
		}

		// Run summary
		System.out.println("ETL Run Summary:");
		System.out.println("Rows read: " + rowsRead);
		System.out.println("Rows transformed: " + processedRows);
		System.out.println("Rows skipped: " + skippedRows);
		System.out.println("Output file: " + outputPath);
	}
}
