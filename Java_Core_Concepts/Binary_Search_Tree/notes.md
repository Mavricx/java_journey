A **Binary Search Tree (BST)** is a special type of binary tree where each node contains a key greater than all the keys in its left subtree and less than those in its right subtree. This property enables efficient searching, insertion, and deletion operations.

### Key Properties
- **Left Subtree:** Contains only nodes with keys less than the parent node.
- **Right Subtree:** Contains only nodes with keys greater than the parent node.
- **No Duplicate Nodes:** Typically, BSTs do not allow duplicate values.

- a. Left Subtree Nodes < Root
- b. Right Subtree Nodes > Root
- c. Left & Right Subtrees are also BST with no duplicates

### Operations and Time Complexity
- **Search:** O(h)
- **Insertion:** O(h)
- **Deletion:** O(h)

Where `h` is the height of the tree. In the best case (balanced tree), `h = log₂N`, making operations very efficient. In the worst case (skewed tree), `h = N`.

> Strategy: Most problems will be solved using recursion i.e. by dividing into sub problems and making recursive calls on subtrees.

### Applications
- Searching and sorting data
- Implementing dynamic sets and lookup tables
- Used in databases and file systems for indexing

### Example

```plaintext
      8
     / \
    3   10
   / \    \
  1   6    14
     / \   /
    4   7 13
```

In this example, all left children are less than their parent, and all right children are greater.

### note
-> InOrder(left->root->right) traversal in the bst always gives a sorted sequence.
## AVL Trees

An **AVL Tree** is a self-balancing binary search tree where the difference between the heights of the left and right subtrees of any node (called the balance factor) is at most 1. This property ensures that the tree remains approximately balanced, leading to efficient operations.

### Key Properties
- **Balance Factor:** For every node, `Balance Factor = Height(Left Subtree) - Height(Right Subtree)`. It must be `-1`, `0`, or `1`.
- **Self-Balancing:** After every insertion or deletion, the tree is rebalanced using rotations to maintain the balance factor.

### Rotations
To restore balance, AVL trees use the following rotations:
1. **Right Rotation (RR):** Used when the left subtree is too tall.
2. **Left Rotation (LL):** Used when the right subtree is too tall.
3. **Left-Right Rotation (LR):** A combination of left and right rotations.
4. **Right-Left Rotation (RL):** A combination of right and left rotations.

### Operations and Time Complexity
- **Search:** O(log N)
- **Insertion:** O(log N)
- **Deletion:** O(log N)

The time complexity is logarithmic because the height of the tree is always maintained as `O(log N)` due to balancing.

### Applications
- Databases and file systems for indexing
- Memory management in operating systems
- Dynamic sets and lookup tables

### Example

```plaintext
    30
     /  \
   20    40
  /  \
10    25
```

If a node is inserted or deleted such that the balance factor of any node becomes invalid, rotations are performed to restore balance.

### Advantages of AVL Trees
- Guaranteed logarithmic height ensures efficient operations.
- Suitable for applications requiring frequent insertions and deletions.

### Disadvantages of AVL Trees
- Slightly more complex to implement compared to simple binary search trees.
- Rotations add overhead during insertions and deletions.

> Note: AVL trees are a good choice when the dataset is dynamic and requires frequent updates.