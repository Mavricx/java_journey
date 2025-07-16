> Binary Tree is a Hierarchical Data structure.

### Tree vs Binary Tree

| Feature           | Tree                               | Binary Tree                                          |
| ----------------- | ---------------------------------- | ---------------------------------------------------- |
| Children per node | Any number of children             | At most two children                                 |
| Structure         | More flexible, can be wide or deep | More structured, often used for efficient algorithms |

Binary trees are the foundation for more advanced structures like binary search trees, heaps, and AVL trees.

| Term         | Description                                                                                                            |
| ------------ | ---------------------------------------------------------------------------------------------------------------------- |
| **Root**     | The topmost node in the tree. It is the starting point and does not have a parent.                                     |
| **Branch**   | Any node that has at least one child. Branches connect the root to the leaves and help form the structure of the tree. |
| **Leaf**     | A node that does not have any children. Leaves are the endpoints of the tree and represent the final data elements.    |
| **Child**    | A node that is directly connected to another node when moving away from the root.                                      |
| **Parent**   | A node that has one or more children. Each child node has exactly one parent.                                          |
| **Level**    | The distance from the root node, where the root is at level 0, its children are at level 1, and so on.                 |
| **Depth**    | The number of edges from the root to a given node. Depth of the root is 0.                                             |
| **Subtree**  | A tree consisting of a node and all its descendants.                                                                   |
| **Ancestors**| All nodes along the path from a given node up to the root.                                                             |

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


### Build tree preorder
Preorder traversal is a way to visit all nodes in a binary tree. In preorder, you visit the root node first, then recursively traverse the left subtree, followed by the right subtree.

**Preorder Steps:**
1. Visit the root node.
2. Traverse the left subtree in preorder.
3. Traverse the right subtree in preorder.

**Java Example:**
```java
void preorder(TreeNode node) {
    if (node == null) return;
    System.out.print(node.value + " ");
    preorder(node.left);
    preorder(node.right);
}
```

Preorder is useful for copying trees or expressing their structure.
