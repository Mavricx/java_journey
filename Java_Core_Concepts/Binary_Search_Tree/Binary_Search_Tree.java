package Java_Core_Concepts.Binary_Search_Tree;

public class Binary_Search_Tree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BST {
        Node root;

        public static Node buildBST(Node root, int values[]) {
            for (int a : values) {
                root = insert(root, a);
            }
            return root;
        }

        public static Node insert(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }
            if (root.data > val) {
                root.left = insert(root.left, val);
            }
            if (root.data < val) {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static void inOrder(Node root) {
            if (root == null)
                return;
            inOrder(root.left);
            System.out.print(root.data + "  ");
            inOrder(root.right);
        }

        public static boolean search(Node root, int key) {
            if (root == null)
                return false;
            if (root.data == key)
                return true;

            if (root.data > key)
                return search(root.left, key);
            if (root.data < key)
                return search(root.right, key);

            return false;
        }

        public Node deleteNode(Node root, int key) {
            // three cases
            // 1.key node is a leaf(No children):->Delete Node -> replace with null
            // 2.key node have one children.:-> Delete Node -> replace with a child node.
            // 3.key node have two children.:-> Replace value with inorder successor->
            // delete the node for inorder successor

            // Remember the inOrder successor is "Left most node in the right subtree."

            if (root.data < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.data > key) {
                root.left = deleteNode(root.left, key);
            } else {// if node found
                    // case -1
                if (root.left == null && root.right == null) {
                    return null;
                }
                // case-2
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // case -3:
                // findInOrderSuccessor
                Node is = findInOrderSuccessor(root.right);
                root.data = is.data;
                root.right = deleteNode(root.right, is.data);
            }
            return root;

        }

        public Node findInOrderSuccessor(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        root = bst.buildBST(root, values);
        // bst.inOrder(root);
        // System.out.println(bst.search(root, 1));
        root = bst.deleteNode(root, 5);
        bst.inOrder(root);
    }
}
