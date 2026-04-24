# answers.md

Heuristic 1:
Name: H2.1 - All data should be hidden within its class.
Explanation:
This heuristic means that data inside a class should be private and only accessed through methods when necessary. This improves readability and maintainability because it protects the internal state of the class and prevents outside code from making unintended changes. In lecture, this was explained as making class attributes private and controlling access to data through well-defined methods.

Heuristic 2:
Name: H2.8 - A class should capture one and only one key abstraction.
Explanation:
This heuristic means that each class should focus on representing one clear concept or responsibility. This improves maintainability because classes are easier to understand, test, and modify when they are not responsible for too many things. In lecture, this idea was described as avoiding mixing multiple responsibilities into a single class.

Heuristic 3:
Name: H3.2 - Do not create god classes/objects in your system.
Explanation:
This heuristic warns against creating classes that control too much of the system’s logic or data. This improves maintainability because large, overly powerful classes are difficult to modify and can affect many other parts of the program when changed. In lecture, this was illustrated by showing how god classes centralize too much responsibility and should instead be broken into smaller classes.