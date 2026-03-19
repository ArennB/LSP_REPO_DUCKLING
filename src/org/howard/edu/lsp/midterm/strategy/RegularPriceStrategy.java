package org.howard.edu.lsp.midterm.strategy;

/**
 * Price strategy for regular customers (no discount).
 * @author arenn
 */
public class RegularPriceStrategy implements PriceStrategy {
    /**
     * Returns the original price (no discount).
     * @param price the original price
     * @return the original price
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
