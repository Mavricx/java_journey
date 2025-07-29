### Heap and Priority Queue: Are They the Same?

While heaps and priority queues are closely related, they are not exactly the same:

- A **heap** is a specific data structure that satisfies the heap property (max-heap or min-heap). It is often implemented as an array or binary tree.
- A **priority queue** is an abstract data type that allows elements to be inserted and removed based on their priority.

Heaps are commonly used as the underlying data structure to implement priority queues because they provide efficient insertion and deletion operations based on priority.

In summary, a heap is a data structure, while a priority queue is a concept that can be implemented using a heap.

## Heaps

A **heap** is a specialized tree-based data structure that satisfies the **heap property**. The heap property states that for a given node:

- In a **max-heap**, the value of a parent node is always greater than or equal to the values of its children.
- In a **min-heap**, the value of a parent node is always less than or equal to the values of its children.

### Characteristics of Heaps

1. **Complete Binary Tree**: A heap is always a complete binary tree, meaning all levels are fully filled except possibly the last level, which is filled from left to right.
2. **Heap Property**: The heap property ensures the ordering of elements as described above (max-heap or min-heap).

### Types of Heaps

1. **Max-Heap**:

   - The root node contains the largest value.
   - Every parent node is greater than or equal to its child nodes.

2. **Min-Heap**:
   - The root node contains the smallest value.
   - Every parent node is less than or equal to its child nodes.

### Common Operations

1. **Insertion**:

   - Add the new element at the end of the heap (maintaining the complete binary tree property).
   - Perform an "up-heap" or "heapify-up" operation to restore the heap property.

2. **Deletion (Extract Max/Min)**:

   - Remove the root element (largest in max-heap, smallest in min-heap).
   - Replace the root with the last element in the heap.
   - Perform a "down-heap" or "heapify-down" operation to restore the heap property.

3. **Peek**:

   - Retrieve the root element without removing it.

4. **Heapify**:
   - Convert an arbitrary array into a valid heap.

### Applications of Heaps

1. **Priority Queues**: Heaps are commonly used to implement priority queues where elements with higher priority are served first.
2. **Heap Sort**: A sorting algorithm that uses a heap to sort elements in O(n log n) time.
3. **Graph Algorithms**: Used in algorithms like Dijkstra's and Prim's for efficient minimum/maximum priority retrieval.
4. **Median Maintenance**: Heaps can be used to dynamically find the median of a stream of numbers.

### Advantages of Heaps

- Efficient insertion and deletion operations with O(log n) complexity.
- Useful for implementing priority-based systems.

### Disadvantages of Heaps

- Not suitable for searching arbitrary elements (O(n) complexity).
- Requires additional memory for maintaining the complete binary tree structure.

### Example of a Max-Heap

```
         50
        /  \
      30    20
     / \   / \
    15 10 8   5
```

### Example of a Min-Heap

```
          5
         / \
      10   15
     / \   / \
    20 30 50  8
```

## Notes.

- Heaps are not implemented as class because insertion of new node will take too much time( 1.O(n):for traversing + 2.extra time for placing new node at correct position.)
- We visualize the heap using binary tree but we implement it using array or array list due the reason mentioned above.
- If the index of a node is `i` the the left child of that node will have index `2i+1` and right child will have index of `2i+2`.
- if node idx=i
  then left child=2i+1
       right child=2i+2
