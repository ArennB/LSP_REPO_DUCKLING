package org.howard.edu.lsp.assignment3;

/**
 * ProductTransformer applies transformation rules to a list of Product objects.
 */

import java.util.List;

public class ProductTransformer {
    /**
     * Applies all transformation rules to the given list of products.
     * @param products List of Product objects to transform
     */
    public void transform(List<Product> products) {
        for (Product p : products) {
            p.applyTransformations();
        }
    }
}
