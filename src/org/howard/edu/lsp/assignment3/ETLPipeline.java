package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ETLPipeline orchestrates the Extract, Transform, and Load process for product data.
 * It reads products from a CSV file, applies transformation rules, and writes the results to a new CSV file.
 */
public class ETLPipeline {
	/**
	 * Main entry point for the ETL pipeline. Reads, transforms, and writes product data.
	 *
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {
		String inputPath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";
		int[] summary = new int[2]; // [rowsRead, rowsSkipped]
		ProductExtractor extractor = new ProductExtractor();
		List<Product> products = extractor.extract(inputPath, summary);
		if (summary[0] == -1) return; // error reading file
		if (products.isEmpty()) {
			// header-only
			try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputPath))) {
				bw.write("ProductID,Name,Price,Category,PriceRange");
				bw.newLine();
			} catch (IOException e) {
				System.err.println("Error writing output file: " + e.getMessage());
		}
			System.out.println("Input file contains only the header row. Output file contains only the header row.");
			System.out.println("ETL Run Summary:");
			System.out.println("Rows read: 0");
			System.out.println("Rows transformed: 0");
			System.out.println("Rows skipped: 0");
			System.out.println("Output file: " + outputPath);
			return;
		}
		ProductTransformer transformer = new ProductTransformer();
		transformer.transform(products);
		ProductLoader loader = new ProductLoader();
		loader.load(products, outputPath);
		System.out.println("ETL Run Summary:");
		System.out.println("Rows read: " + summary[0]);
		System.out.println("Rows transformed: " + products.size());
		System.out.println("Rows skipped: " + summary[1]);
		System.out.println("Output file: " + outputPath);
	}
}

