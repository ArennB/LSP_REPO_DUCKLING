package org.howard.edu.lsp.midterm.strategy;

/**
 * Price strategy for VIP customers (20% discount).
 * @author arenn
 */
public class VIPPriceStrategy implements PriceStrategy {
    /**
     * Returns the price after a 20% discount.
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
