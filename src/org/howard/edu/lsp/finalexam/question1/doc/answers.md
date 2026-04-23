# answers.md

## Part 1:
Shared Resource #1: nextId

Shared Resource #2: requests

Concurrency Problem: A race condition may occur

Why addRequest() is unsafe: addRequest() is unsafe because it accesses and modifies shared resources (nextId and requests) without synchronization. If multiple threads call addRequest() at the same time, they may generate duplicate IDs or corrupt the requests list.

## Part 2:
Fix A: This fix is not correct. It synchronizes ID generation, so it prevents multiple threads from updating nextId at the same time. However, addRequest() still modifies the shared requests ArrayList without synchronization, so the list can still be accessed unsafely by multiple threads.

Fix B: This fix is correct. Synchronizing addRequest() protects the full critical section, meaning only one thread at a time can generate an ID and add the request to the shared list.

Fix C: This fix is not correct. It only synchronizes the method that returns the list, but it does not protect addRequest(), getNextId(), or requests.add(request). The race condition can still happen when multiple threads call addRequest() at the same time.

## Part 3:
No, getNextId() should not be public. According to Arthur Riel’s heuristics, a class should hide its internal implementation details and expose only what is necessary. The ID generation is an internal responsibility of RequestManager, so allowing external classes to access getNextId() would violate encapsulation and reduce maintainability.

## Part 4:
Description: 
An alternative approach is to use a Lock, such as ReentrantLock, instead of the synchronized keyword. The lock is acquired before the critical section and released in a "finally" block to ensure it is always unlocked. This makes addRequest() thread-safe because only one thread at a time can generate an ID and add to the shared requests list.

Code Snippet:

private final Lock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        requests.add("Request-" + id + " from " + studentName);
    } finally {
        lock.unlock();
    }
}
