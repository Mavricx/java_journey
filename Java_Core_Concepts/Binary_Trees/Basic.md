> Binary Tree is a Hierarchical Data structure.

### Tree vs Binary Tree

| Feature           | Tree                               | Binary Tree                                          |
| ----------------- | ---------------------------------- | ---------------------------------------------------- |
| Children per node | Any number of children             | At most two children                                 |
| Structure         | More flexible, can be wide or deep | More structured, often used for efficient algorithms |

Binary trees are the foundation for more advanced structures like binary search trees, heaps, and AVL trees.

| Term          | Description                                                                                                            |
| ------------- | ---------------------------------------------------------------------------------------------------------------------- |
| **Root**      | The topmost node in the tree. It is the starting point and does not have a parent.                                     |
| **Branch**    | Any node that has at least one child. Branches connect the root to the leaves and help form the structure of the tree. |
| **Leaf**      | A node that does not have any children. Leaves are the endpoints of the tree and represent the final data elements.    |
| **Child**     | A node that is directly connected to another node when moving away from the root.                                      |
| **Parent**    | A node that has one or more children. Each child node has exactly one parent.                                          |
| **Level**     | The distance from the root node, where the root is at level 0, its children are at level 1, and so on.                 |
| **Depth**     | The number of edges from the root to a given node. Depth of the root is 0.                                             |
| **Subtree**   | A tree consisting of a node and all its descendants.                                                                   |
| **Ancestors** | All nodes along the path from a given node up to the root.                                                             |

For example, in Java:

```java
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
```

- The first created `TreeNode` is usually the root.
- Any node with non-null `left` or `right` references is a branch.
- Nodes where both `left` and `right` are `null` are leaves.

### Build tree preOrder

PreOrder traversal is a way to visit all nodes in a binary tree. In preOrder, you visit the root node first, then recursively traverse the left subtree, followed by the right subtree.

**PreOrder Steps:**

1. Visit the root node.
2. Traverse the left subtree in preOrder.
3. Traverse the right subtree in preOrder.

PreOrder is useful for copying trees or expressing their structure.

### Types of Binary Tree Traversal

Binary trees can be traversed in several ways to visit all their nodes. The most common recursive traversal methods are:

#### 1. PreOrder Traversal
- **Order:** Root → Left Subtree → Right Subtree
- **Explanation:** In PreOrder traversal, you start by visiting the root node first. Then, you recursively traverse the left subtree, followed by the right subtree. This method is useful for creating a copy of the tree or expressing its structure.
- **Example Output:** For a tree with nodes 1, 2, 3, PreOrder would print: `1 2 3`

#### 2. InOrder Traversal
- **Order:** Left Subtree → Root → Right Subtree
- **Explanation:** In InOrder traversal, you first recursively visit the left subtree, then the root node, and finally the right subtree. This traversal is commonly used for binary search trees because it visits nodes in ascending order.
- **Example Output:** For a tree with nodes 1, 2, 3, InOrder would print: `2 1 3`

#### 3. PostOrder Traversal
- **Order:** Left Subtree → Right Subtree → Root
- **Explanation:** In PostOrder traversal, you recursively visit the left subtree, then the right subtree, and finally the root node. This method is useful for deleting trees or evaluating expressions in expression trees.
- **Example Output:** For a tree with nodes 1, 2, 3, PostOrder would print: `2 3 1`

---

### Iterative Traversal: Level Order Traversal

Level Order traversal is an iterative method that visits nodes level by level, starting from the root and moving down. At each level, nodes are visited from left to right.

- **Explanation:** Level Order traversal uses a queue to keep track of nodes at each level. You start with the root node, then visit all its children, then their children, and so on. This method is useful for breadth-first searches and is commonly used in scenarios where you need to process nodes in the order they appear by level.
- **Example Output:** For a tree with nodes 1, 2, 3, Level Order would print: `1 2 3`


