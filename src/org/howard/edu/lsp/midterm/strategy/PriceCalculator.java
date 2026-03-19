package org.howard.edu.lsp.midterm.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculates final prices using the Strategy pattern.
 * Selects the appropriate PriceStrategy based on customer type.
 * @author arenn
 */
public class PriceCalculator {
    private static final Map<String, PriceStrategy> strategies = new HashMap<>();

    static {
        strategies.put("REGULAR", new RegularPriceStrategy());
        strategies.put("MEMBER", new MemberPriceStrategy());
        strategies.put("VIP", new VIPPriceStrategy());
        strategies.put("HOLIDAY", new HolidayPriceStrategy());
    }

    /**
     * Calculates the final price for a customer using the appropriate strategy.
     * @param customerType the type of customer (e.g., REGULAR, MEMBER, VIP, HOLIDAY)
     * @param price the original price
     * @return the final price after applying the strategy, or the original price if type is unknown
     */
    public double calculatePrice(String customerType, double price) {
        PriceStrategy strategy = strategies.get(customerType);
        if (strategy == null) {
            return price;
        }
        return strategy.calculatePrice(price);
    }
}
