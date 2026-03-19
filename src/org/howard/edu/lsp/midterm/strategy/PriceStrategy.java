package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for price calculation.
 * @author arenn
 */
public interface PriceStrategy {
    /**
     * Calculates the final price based on the original price.
     * @param price the original price
     * @return the final price after applying the strategy
     */
    double calculatePrice(double price);
}
