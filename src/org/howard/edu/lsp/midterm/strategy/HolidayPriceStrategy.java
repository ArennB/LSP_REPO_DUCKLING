package org.howard.edu.lsp.midterm.strategy;

/**
 * Price strategy for holiday customers (15% discount).
 * @author arenn
 */
public class HolidayPriceStrategy implements PriceStrategy {
    /**
     * Returns the price after a 15% discount.
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
