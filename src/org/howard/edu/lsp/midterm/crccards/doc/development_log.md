# development_log.md

## External Resources Used

### AI Tool: ChatGPT

**Prompt 1:**
What data structure should I use for TaskManager to efficiently store tasks, prevent duplicates, and allow lookup by ID?

**Response:**
ChatGPT recommended using a Map<String, Task>, specifically a LinkedHashMap, to allow efficient lookup and prevent duplicate keys while preserving insertion order.

---

**Prompt 2:**
How should I implement setStatus() so it only allows valid values and handles invalid ones correctly?

**Response:**
ChatGPT explained to check for valid statuses ("OPEN", "IN_PROGRESS", "COMPLETE") and set the status to "UNKNOWN" if the input does not match any valid value.

---

**Prompt 3:**
What format should my toString() method return to match the expected output?

**Response:**
ChatGPT specified the exact format: taskId + " " + description + " [" + status + "].

---

**Prompt 4:**
How do I prevent duplicate task IDs in TaskManager?

**Response:**
ChatGPT suggested using containsKey() before inserting into the map and throwing an IllegalArgumentException if a duplicate is found.

---

**Prompt 5:**
How should I implement getTasksByStatus()?

**Response:**
ChatGPT recommended iterating through all tasks, filtering by matching status, and returning the results in a List<Task>.

---

**Prompt 6:**
Why does TaskManager collaborate with Task but Task does not collaborate with TaskManager?

**Response:**
ChatGPT explained that TaskManager depends on Task to manage collections, while Task is only responsible for its own data and behavior, maintaining separation of concerns.