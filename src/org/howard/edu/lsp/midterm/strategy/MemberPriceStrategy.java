package org.howard.edu.lsp.midterm.strategy;

/**
 * Price strategy for member customers (10% discount).
 * @author arenn
 */
public class MemberPriceStrategy implements PriceStrategy {
    /**
     * Returns the price after a 10% discount.
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
