package Java_Core_Concepts.Binary_Search_Tree;

import java.util.ArrayList;

import javax.swing.border.LineBorder;

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

        // insert in BST
        // time complexity O(h) h is the height of the tree
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

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
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

        public void printInRange(Node root, int k1, int k2) {

            if (root == null) {
                return;
            }

            if (root.data >= k1 && root.data <= k2) {
                printInRange(root.left, k1, k2);
                System.out.print(root.data + " ");
                printInRange(root.right, k1, k2);
            }
            if (root.data > k2) {
                printInRange(root.right, k1, k2);
            } else {
                printInRange(root.left, k1, k2);
            }
        }

        public void rootToLeafPath(Node root, ArrayList<Integer> path) {
            if (root == null) {
                return;
            }
            path.add(root.data);
            if (root.left == null && root.right == null) {
                System.out.println(path);
            } else {
                rootToLeafPath(root.left, path);
                rootToLeafPath(root.right, path);
            }
            path.remove(path.size() - 1);
        }

        public boolean isValidBST(Node root, Node min, Node max) {
            // approach-1
            // get inOrder traversal....if sorted then valid if not not valid.

            // approach-2
            // check max value of in left subTree < root node
            // min value in right subtree > root node
            if (root == null) {
                return true;
            }

            if (min != null && root.data <= min.data) {
                return false;
            }
            if (max != null && root.data >= max.data) {
                return false;
            }
            return isValidBST(root.left, min, root)
                    && isValidBST(root.right, root, max);
        }

        public Node mirror_a_BST(Node root) {// in the same binary search tree.
            if (root == null)
                return null;
            Node leftSubTree = mirror_a_BST(root.left);
            Node rightSubTree = mirror_a_BST(root.right);
            root.left = rightSubTree;
            root.right = leftSubTree;
            return root;
        }

        public Node sortedArrayToBalancedBST(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            Node root = new Node(arr[mid]);
            root.left = sortedArrayToBalancedBST(arr, start, mid - 1);
            root.right = sortedArrayToBalancedBST(arr, mid + 1, end);
            return root;
        }

        public Node sortedArrayListToBalancedBST(ArrayList<Integer> arr, int start, int end) {
            if (start > end)
                return null;
            int mid = (start + end) / 2;
            Node root = new Node(arr.get(mid));
            root.left = sortedArrayListToBalancedBST(arr, start, mid - 1);
            root.right = sortedArrayListToBalancedBST(arr, mid + 1, end);
            return root;
        }

        public static void getInOrder(Node root, ArrayList<Integer> ans) {
            if (root == null)
                return;
            getInOrder(root.left, ans);
            ans.add(root.data);
            getInOrder(root.right, ans);
        }

        public Node bstToBalancedBST(Node root) {
            // get the inOrder sequence.
            ArrayList<Integer> sorted = new ArrayList<>();
            getInOrder(root, sorted);
            // get the bst from inOrder sequence
            return sortedArrayListToBalancedBST(sorted, 0, sorted.size() - 1);

        }

        static class Info {
            boolean isBST;
            int size;
            int min;
            int max;

            public Info(boolean isBST, int size, int min, int max) {
                this.isBST = isBST;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }

        public static int maxBst = 0;

        public Info largestBST(Node root) {

            if (root == null) {
                return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

            if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
                return new Info(false, size, min, max);
            }
            if (leftInfo.isBST && rightInfo.isBST) {
                maxBst = Math.max(maxBst, size);
                return new Info(true, size, min, max);
            }
            return new Info(false, size, min, max);
        }

        public Node merge2Bst(Node root1, Node root2) {
            // step-1:find sorted arrays from inorder traversal for root1 and root2
            // step-2: merge two sorted array
            // step-3: build balanced bst form the merged array.
            ArrayList<Integer> sorted1 = new ArrayList<>();
            ArrayList<Integer> sorted2 = new ArrayList<>();
            getInOrder(root1, sorted1);
            getInOrder(root2, sorted2);
            int i = 0, j = 0;
            ArrayList<Integer> merged = new ArrayList<>();
            while (i < sorted1.size() && j < sorted2.size()) {
                if (sorted1.get(i) <= sorted2.get(j)) {
                    merged.add(sorted1.get(i));
                    i++;
                } else {
                    merged.add(sorted2.get(j));
                    j++;
                }
            }
            while (i < sorted1.size()) {
                merged.add(sorted1.get(i));
                i++;
            }
            while (j < sorted2.size()) {
                merged.add(sorted2.get(j));
                j++;
            }

            Node newRoot = sortedArrayListToBalancedBST(merged, 0, merged.size() - 1);
            return newRoot;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        // int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = null;
        // root = bst.buildBST(root, values);
        // bst.inOrder(root);
        // System.out.println(bst.search(root, 1));
        // root = bst.deleteNode(root, 5);
        // bst.inOrder(root);
        // bst.printInRange(root, 5, 12);
        // System.out.println(bst.isValidBST(root, null, null));
        // root = bst.mirror_a_BST(root);
        // bst.inOrder(root);
        // root = bst.sortedArrayToBalancedBST(arr, 0, arr.length - 1);
        // // bst.preOrder(root);
        // System.out.println(bst.largestBST(root).size);

        BST bst1 = new BST();
        bst1.root = new Node(2);
        bst1.root.left = new Node(1);
        bst1.root.right = new Node(3);

        // 2
        // / \
        // 1 3

        BST bst2 = new BST();
        bst2.root = new Node(9);
        bst2.root.left = new Node(4);
        bst2.root.right = new Node(12);

        // 9
        // / \
        // 4 12
        bst1.root=bst1.merge2Bst(bst1.root, bst2.root);
        bst1.inOrder(bst1.root);
    }
}
