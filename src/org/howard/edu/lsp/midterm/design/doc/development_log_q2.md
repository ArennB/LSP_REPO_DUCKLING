# development_log_q2.md

## External Resources Used

### ChatGPT

**Prompt 1:**  
What design problems are present in the `OrderProcessor` class from an object-oriented perspective?

**Response:**  
The class has poor encapsulation because its fields are public, allowing unrestricted access and modification. It also violates the Single Responsibility Principle since it performs multiple unrelated tasks such as calculating tax, printing receipts, writing to a file, sending emails, and logging. This results in low cohesion and makes the class difficult to maintain.

---

**Prompt 2:**  
Why is the `OrderProcessor` class considered tightly coupled?

**Response:**  
The class is tightly coupled because it directly depends on specific implementations like `FileWriter` and uses hardcoded values such as the file name. This makes it difficult to change how data is stored or processed without modifying the class.

---

**Prompt 3:**  
What kinds of classes should be introduced to improve the design?

**Response:**  
The design can be improved by separating responsibilities into multiple classes. An `Order` class should store order data, an `OrderRepository` should handle persistence, a `ReceiptPrinter` should handle output formatting, an `EmailService` should manage communication, and a separate class should handle pricing logic such as tax and discounts.

---

**Prompt 4:**  
Should tax and discount logic stay in `OrderProcessor`?

**Response:**  
Tax and discount logic should be moved into a separate class, such as a `PricingService`, to isolate business rules. This makes the system easier to maintain and extend when pricing rules change.

---

**Prompt 5:**  
How should I explain the improved design using CRC cards?

**Response:**  
Each CRC card should define a class, its responsibilities, and its collaborators. The redesigned system should show that responsibilities are distributed across multiple classes, with `OrderProcessor` coordinating the workflow and delegating tasks to specialized components.

---

**Prompt 6:**  
Why is the redesigned system better than the original one?

**Response:**  
The redesigned system improves separation of concerns by assigning each responsibility to a specific class. This increases cohesion, reduces coupling, and makes the system easier to maintain, test, and extend.