package Java_Core_Concepts.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);// build left subtree for the binary tree.
            newNode.right = buildTree(nodes);// build right subtree for the binary tree.
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                System.out.print("-1 ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            postOrder((root.left));
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node curNode = q.remove();
                if (curNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curNode.data + " ");
                    if (curNode.left != null) {
                        q.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        q.add(curNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int nodeCount(Node root) {
            if (root == null) {
                return 0;
            }
            int lc = nodeCount(root.left);
            int rc = nodeCount(root.right);
            return (lc + rc + 1);
        }

        public static int sumOfNode(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sumOfNode(root.left);
            int rightSum = sumOfNode(root.right);
            return leftSum + rightSum + root.data;
        }

        public static int diameter(Node root) {// no of nodes in the longest path between 2 leaves. time complexity
                                               // :O(n^2)
            if (root == null) {
                return 0;
            }
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int selfDiameter = lh + rh + 1;
            return Math.max(leftDiameter, Math.max(rightDiameter, selfDiameter));

        }
        // approach 2 for diameter calculation :Time complexity:O(n)

        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter2(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);
            int diam = Math.max(leftInfo.diam, Math.max(rightInfo.diam, (leftInfo.ht + rightInfo.ht + 1)));
            int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, height);

        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        tree.levelOrder(root);
        System.out.println(tree.height(root));
        System.out.println(tree.nodeCount(root));
        System.out.println(tree.sumOfNode(root));
        System.out.println(tree.diameter(root));
        System.out.println(tree.diameter2(root).diam);

    }
}
