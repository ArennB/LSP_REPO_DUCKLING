The primary difference between Assignment 2 and Assignment 3 lies in the architectural shift from a procedural design to a fully object-oriented design. In Assignment 2, the entire ETL (Extract, Transform, Load) process was implemented within a single class and largely within one method. All logic—including file reading, validation, transformation rules, and output—was tightly coupled, and product data was represented as arrays of strings. This procedural structure made the program less modular, harder to test independently, and more difficult to extend without modifying existing code.

In contrast, Assignment 3 refactors the solution into multiple classes, each with a clearly defined, single responsibility. The Product class encapsulates product data and related transformation logic, replacing fragile string arrays with a well-defined object. The ProductExtractor class is responsible solely for reading and parsing input data. The ProductTransformer applies business rules such as discounts and price classification. The ProductLoader handles writing the transformed data to the output file. Finally, the ETLPipeline class coordinates these components and manages the overall workflow.

This redesign applies key object-oriented principles:

    Encapsulation: Product data and related behavior are bundled within the Product class.
    Separation of Concerns: Extraction, transformation, and loading are handled by distinct classes.
    Single Responsibility Principle: Each class has one clear and focused purpose.
    Modularity: Components can be modified, tested, or extended independently.
    Improved Maintainability and Extensibility: New transformation rules or input formats can be added without restructuring the entire program.

By eliminating the monolithic structure of Assignment 2 and replacing it with a coordinated set of interacting objects, Assignment 3 becomes easier to reason about, test, and maintain. The design also reduces tight coupling and makes future enhancements significantly safer and cleaner to implement.

To verify that Assignment 3 preserved the functionality of Assignment 2, I used the same input file (data/products.csv) and executed both programs. I compared the resulting transformed_products.csv files to ensure that the output content, formatting, header row, and transformation results were identical. I also tested edge cases—including header-only input, malformed rows, invalid data types, and valid records—to confirm that row skipping logic, discount calculations, premium categorization, and price range assignments behaved exactly the same. This validation ensured that the refactoring improved the design without altering the program’s external behavior.