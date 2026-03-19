# Design Evaluation of PriceCalculator

The current implementation of the `PriceCalculator` class is not maintainable or extensible for several reasons.

First, it violates the Open/Closed Principle. The method uses a series of `if` statements to handle each customer type, so adding a new customer type or discount rule requires modifying the existing method. This increases the risk of introducing bugs and makes the code harder to maintain over time.

Second, all pricing rules are hardcoded in one place. This makes the design rigid and difficult to extend, since every change must be made inside the same method.

Third, the class lacks separation of concerns. It combines all discount behaviors into a single method instead of separating them into individual components. This reduces readability and makes the code harder to test and reason about.

Additionally, the design relies on raw string values such as `"REGULAR"` and `"VIP"` to control behavior. This approach is error-prone because invalid or misspelled values are not handled in a structured way.

Finally, the class does not take advantage of polymorphism or a design pattern such as Strategy. Encapsulating each pricing rule in its own class would make the system easier to extend and maintain.

## Conclusion

As the system evolves and more customer types or pricing rules are added, the current design will become increasingly complex and error-prone. Refactoring to use the Strategy pattern would improve maintainability and extensibility by allowing new pricing strategies to be added without modifying existing code.