package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern for price calculation.
 * Prints final prices for different customer types using a purchase price of 100.0.
 * Output format:
 * REGULAR: 100.0
 * MEMBER: 90.0
 * VIP: 80.0
 * HOLIDAY: 85.0
 *
 * @author arenn
 */
public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        System.out.println("REGULAR: " + calculator.calculatePrice("REGULAR", price));
        System.out.println("MEMBER: " + calculator.calculatePrice("MEMBER", price));
        System.out.println("VIP: " + calculator.calculatePrice("VIP", price));
        System.out.println("HOLIDAY: " + calculator.calculatePrice("HOLIDAY", price));
    }
}
