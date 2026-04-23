# AIUsage.md

AI Tools Used:
ChatGPT, Claude

Prompts Used:

1. "Identify the shared resources and possible race conditions in this Java class that uses nextId and an ArrayList."

2. "Evaluate whether synchronizing getNextId(), addRequest(), or getRequests() correctly solves concurrency issues and explain why."

3. "Based on object-oriented design heuristics, should helper methods like getNextId() be public or private?"

4. "Show an example of how to make a Java method thread-safe using ReentrantLock instead of synchronized."

How AI Helped:
AI helped me review the code and identify shared resources and possible race conditions. It also helped me understand why certain synchronization fixes worked or did not work and provided an example of using a lock as an alternative to synchronized.

Reflection:
I learned how race conditions occur when shared data is accessed by multiple threads and how synchronization or locks can be used to prevent concurrency issues.