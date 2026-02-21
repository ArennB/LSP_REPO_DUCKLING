## Prompts
(1, Prompt) Brainstorm ways to make my ETL pipeline more object-oriented.
(1, Response) To make your ETL program more object-oriented (OO), you can:

1. **Create a Product class:**  
   Represent each product as an object with fields for productId, name, price, category, and priceRange. This encapsulates product data and related logic.

2. **Encapsulate ETL steps in classes:**  
   - Extractor: Handles reading and parsing the CSV file into Product objects.
   - Transformer: Applies transformation rules to Product objects.
   - Loader: Handles writing Product objects to the output CSV.

3. **Use methods and encapsulation:**  
   Move transformation logic (e.g., price discount, price range calculation) into methods of the Product class or the Transformer class.

4. **Separate concerns:**  
   Each class should have a single responsibility (SRP). For example, the Extractor should not transform data, and the Loader should not parse input.

5. **Use interfaces or abstract classes:**  
   If you want to support different data sources or output formats in the future, define interfaces like Extractor, Transformer, and Loader.

6. **Add unit tests:**  
   OO design makes it easier to test each component in isolation.




(2, Prompt) What is the right level of class decomposition?
(2, Response) The right level of class decomposition is determined by applying core object-oriented design principles:

1. **Single Responsibility Principle (SRP):**  
   Each class should have one clear purpose. If a class is doing too much (e.g., reading files, transforming data, and writing output), break it into smaller classes.

2. **Encapsulation:**  
   Group related data and behavior together. For example, a Product class should contain product fields and methods for product-specific logic.

3. **Separation of Concerns:**  
   Divide your program into layers or components (e.g., extraction, transformation, loading) so each part can be developed, tested, and changed independently.

4. **Reusability and Extensibility:**  
   Classes should be reusable and easy to extend. If you might want to support new file formats or transformation rules, design with interfaces or abstract classes.

5. **Testability:**  
   Smaller, focused classes are easier to test in isolation.

**Practical approach:**  
- Start by identifying nouns (entities) and verbs (actions) in your requirements.
- Create classes for major entities (e.g., Product) and for major actions or processes (e.g., Extractor, Transformer, Loader).
- If a class grows too large or has multiple reasons to change, split it.
- Avoid over-decomposition (too many tiny classes) unless justified by complexity or future needs.

**In summary:**  
Decompose until each class is focused, understandable, and easy to maintain, but not so much that the design becomes fragmented or hard to follow. Aim for clarity, maintainability, and alignment with the problem domain.




(3, Prompt) What design patterns would best fit this ETL pipeline?
(3, Response) Several classic design patterns fit well for an object-oriented ETL pipeline:

1. **Strategy Pattern:**  
   Use for interchangeable extraction, transformation, or loading strategies. For example, you could have different Transformer classes for different business rules, or different Extractor/Loader classes for CSV, JSON, or database sources.

2. **Template Method Pattern:**  
   Define the ETL process skeleton in a base class (e.g., ETLPipeline), with steps like extract(), transform(), and load() as methods. Subclasses can override specific steps for custom behavior.

3. **Factory Pattern:**  
   Use to create Product objects or to instantiate the correct Extractor/Transformer/Loader based on configuration or file type.

4. **Builder Pattern:**  
   Useful for constructing complex Product objects, especially if you add more fields or optional attributes.

5. **Decorator Pattern:**  
   Add extra transformation steps or logging to the pipeline without modifying the core logic.

6. **Chain of Responsibility Pattern:**  
   For transformation steps, where each transformation is a link in a chain and can pass the Product to the next transformation.

**Typical OO ETL structure:**
- Strategy for each ETL step (Extractor, Transformer, Loader)
- Template Method for the overall pipeline flow
- Factory for instantiating strategies
- Builder for complex Product creation

These patterns make your pipeline flexible, extensible, and easy to maintain. If you want, I can show you a class diagram or code skeleton using these patterns.




(4, Prompt) Add Javadocs for each class and all public methods.
(4, Response) All your classes and public methods now include Javadocs, following Java documentation best practices. This will help with code readability, maintainability, and grading. If you need further documentation or want to review the comments, let me know!




(5, Prompt) Comparing assignment2 with assignment3 and their respective implementations, what is the difference in design between the two?
(5, Response) The main design difference between assignment2 and assignment3 is the use of object-oriented principles:

- **Assignment 2:**  
  - Uses a single class (ETLPipeline) with all logic in the main method.
  - Data is handled as arrays of strings.
  - All ETL steps (extract, transform, load) are tightly coupled in one place.
  - Minimal encapsulation and separation of concerns.

- **Assignment 3:**  
  - Refactored into multiple classes, each with a single responsibility:
    - Product (data and transformation logic)
    - ProductExtractor (reading/parsing)
    - ProductTransformer (applying rules)
    - ProductLoader (writing output)
    - ETLPipeline (orchestration)
  - Uses objects (Product) instead of raw arrays for data.
  - Follows object-oriented design: encapsulation, separation of concerns, and improved maintainability.
  - Easier to test, extend, and understand.

In summary, assignment3 is modular, object-oriented, and maintainable, while assignment2 is procedural and monolithic.