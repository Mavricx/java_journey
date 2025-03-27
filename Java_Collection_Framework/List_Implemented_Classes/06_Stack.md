# Stack in Java

## Overview
A **Stack** is a data structure that operates on the **Last-In-First-Out (LIFO)** principle. This means that the last element added to the stack is the first one to be removed. It is part of the Java Collection Framework and is implemented as a class in the `java.util` package.

## Key Characteristics
- **Inheritance**: The `Stack` class extends `Vector`, inheriting its properties and methods. However, it is specifically designed to operate as a stack, adhering to the LIFO principle.
- **Dynamic Nature**: Since it extends `Vector`, a `Stack` can dynamically grow and shrink as needed.
- **Thread Safety**: Like `Vector`, `Stack` is synchronized, making it thread-safe for use in multi-threaded environments.

## Common Methods
- `push(E item)`: Adds an item to the top of the stack.
- `pop()`: Removes and returns the item at the top of the stack.
- `peek()`: Returns the item at the top of the stack without removing it.
- `isEmpty()`: Checks if the stack is empty.
- `search(Object o)`: Returns the 1-based position of an object in the stack, or `-1` if not found.

## Use Cases
1. **Undo/Redo Functionality**: Stacks are commonly used to implement undo and redo operations in text editors and other applications.
2. **Expression Evaluation**: Used in evaluating and parsing mathematical expressions, such as converting infix to postfix notation.
3. **Backtracking**: Useful in algorithms like depth-first search (DFS) and solving puzzles like the Tower of Hanoi.
4. **Function Call Management**: The call stack in programming languages uses the stack data structure to manage function calls and returns.



## Conclusion
The `Stack` class in Java is a versatile and easy-to-use implementation of the stack data structure. Its LIFO nature makes it ideal for scenarios where the order of operations is critical, such as undo mechanisms, parsing, and algorithmic problem-solving.
