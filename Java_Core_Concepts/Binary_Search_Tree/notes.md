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