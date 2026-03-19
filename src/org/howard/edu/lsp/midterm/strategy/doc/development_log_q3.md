# development_log_q3.md

## External Resources Used

### ChatGPT

**Prompt 1:**  
What is wrong with the current PriceCalculator design?

**Response:**  
The design relies on multiple conditional statements based on customer type strings to determine pricing behavior. This approach makes the code difficult to extend because any new customer type or pricing rule requires modifying the existing method. It also violates the open/closed principle and reduces maintainability as the number of conditions grows.

---

**Prompt 2:**  
How does the Strategy Pattern improve this design?

**Response:**  
The Strategy Pattern improves the design by separating each pricing behavior into its own class that implements a common interface. This removes the need for conditional logic and allows different pricing behaviors to be used interchangeably. New strategies can be added without modifying existing code, which improves extensibility and maintainability.

---

**Prompt 3:**  
What classes are needed to implement the Strategy Pattern?

**Response:**  
The implementation requires a strategy interface that defines the pricing behavior, along with concrete strategy classes for each customer type such as Regular, Member, VIP, and Holiday. A context class (PriceCalculator) is used to apply the appropriate strategy when calculating the final price.

---

**Prompt 4:**  
How should the context class use the strategy?

**Response:**  
The context class should delegate the price calculation to a selected strategy object. This allows the behavior to change dynamically depending on the chosen strategy and keeps the context class focused only on coordinating the calculation.

---

**Prompt 5:**  
Why is this design more maintainable and extensible?

**Response:**  
Each pricing rule is isolated in its own class, which improves readability and makes the system easier to test. New pricing behaviors can be added by creating new strategy classes without modifying existing code. This reduces the risk of introducing bugs and keeps the design flexible as requirements change.

---

**Prompt 6:**  
Why is using separate classes better than using multiple if statements?

**Response:**  
Using separate classes avoids long chains of conditional logic and keeps each pricing rule self-contained. This makes the code easier to understand and modify, and it follows object-oriented principles such as polymorphism and separation of concerns.