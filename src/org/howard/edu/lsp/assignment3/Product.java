package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a product with fields for ID, name, price, category, and price range.
 * Provides methods for parsing from CSV and applying transformation rules.
 */
public class Product {
    int productId;
    String name;
    BigDecimal price;
    String category;
    String priceRange;


    /**
     * Constructs a Product with the given fields.
     * @param productId Product ID
     * @param name Product name
     * @param price Product price
     * @param category Product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Parses a Product from a CSV row.
     * @param fields Array of CSV fields (length 4)
     * @return Product object
     * @throws NumberFormatException if parsing fails
     */
    public static Product fromCSV(String[] fields) throws NumberFormatException {
        int id = Integer.parseInt(fields[0].trim());
        String name = fields[1].trim();
        BigDecimal price = new BigDecimal(fields[2].trim());
        String category = fields[3].trim();
        return new Product(id, name, price, category);
    }

    /**
     * Applies all transformation rules to this product (name, price, category, priceRange).
     */
    public void applyTransformations() {
        name = name.toUpperCase();
        if (category.equalsIgnoreCase("Electronics")) {
            price = price.multiply(new BigDecimal("0.9"));
        }
        price = price.setScale(2, RoundingMode.HALF_UP);
        if (price.compareTo(new BigDecimal("500.00")) > 0 && category.equalsIgnoreCase("Electronics")) {
            category = "Premium Electronics";
        }
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            priceRange = "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            priceRange = "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }
    }

    /**
     * Returns a CSV row representation of this product.
     * @return CSV string
     */
    public String toCSVRow() {
        return productId + "," + name + "," + price.toPlainString() + "," + category + "," + priceRange;
    }
}
