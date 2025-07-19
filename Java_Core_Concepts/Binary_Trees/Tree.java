package Java_Core_Concepts.Binary_Trees;

import java.util.ArrayList;
import java.util.HashMap;
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
        int idx = -1;

        public Node buildTree(int nodes[]) {
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

        public static boolean isIdentical(Node node, Node subRoot) {
            if (node == null && subRoot == null) {
                return true;
            } else if (node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }
            if (!isIdentical(node.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(node.right, subRoot.right)) {
                return false;
            }

            return true;
        }

        public static boolean isSubtree(Node root, Node subRoot) {
            // step-1: find sub root in the main tree.
            // step-2: recursively check the subtree is identical to each other or not.

            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }
            boolean leftAns = isSubtree(root.left, subRoot);
            boolean rightAns = isSubtree(root.right, subRoot);

            return leftAns || rightAns;
        }

        static class NodeInfo {
            Node node;
            int hd;

            NodeInfo(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root) {
            // level order traversal is used to find the top view of the binary tree.
            Queue<NodeInfo> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            q.add(new NodeInfo(root, 0));
            q.add((null));

            while (!q.isEmpty()) {
                NodeInfo curNode = q.remove();
                if (curNode == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curNode.hd)) {
                        map.put(curNode.hd, curNode.node);

                    }

                    if (curNode.node.left != null) {
                        q.add(new NodeInfo(curNode.node.left, curNode.hd - 1));
                        min = Math.min(min, curNode.hd - 1);
                    }
                    if (curNode.node.right != null) {
                        q.add(new NodeInfo(curNode.node.right, curNode.hd + 1));
                        max = Math.max(max, curNode.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                if (map.containsKey(i)) {
                    System.out.print(map.get(i).data + " ");
                }
            }
            System.out.println();
        }

        public static void kthLevel(Node root, int level, int k) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data);
                return;
            }
            kthLevel(root.left, level + 1, k);
            kthLevel(root.right, level + 1, k);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);

            if (root.data == n) {
                return true;
            }
            boolean foundInLeft = getPath(root.left, n, path);
            boolean foundInRight = getPath(root.right, n, path);

            if (foundInLeft || foundInRight) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }

        public static Node lowestCommonAncestor(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            while (i < path1.size() && i < path2.size()) {
                if (path1.get(i).data != path2.get(i).data) {
                    break;
                }
                i++;
            }

            int lca = i - 1;

            return path1.get(lca);
        }

        public static Node lca2(Node root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if (rightLca == null) {
                return leftLca;
            }
            if (leftLca == null) {
                return rightLca;
            }

            return root;

        }

        public static int lcaDist(Node root, int n) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            } else if (leftDist == -1) {
                return rightDist + 1;
            } else {
                return leftDist + 1;
            }

        }

        public static int min_Distance(Node root, int n1, int n2) {
            // minimum distance between two nodes :distance from lca from n1+distance from
            // lca to n2
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca, n1);
            int dist2 = lcaDist(lca, n2);

            return dist1 + dist2;
        }

        // kth ancestor of a node in a binary tree.
        public static int kthAncestor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }

            int leftDist = kthAncestor(root.left, n, k);
            int rightDist = kthAncestor(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }
            int max = Math.max(leftDist, rightDist);
            if (max + 1 == k) {
                System.out.println(root.data);
            }
            return max + 1;
        }
    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // // System.out.println(root.data);
        // tree.levelOrder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.nodeCount(root));
        // System.out.println(tree.sumOfNode(root));
        // System.out.println(tree.diameter(root));
        // System.out.println(tree.diameter2(root).diam);

        int nodes1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree1 = new BinaryTree();
        Node root1 = tree1.buildTree(nodes1);
        /*
         * 1
         * / \
         * 2 3
         * / \/ \
         * 4 5 6 7
         */
        int nodes2[] = { 2, 4, -1, -1, 5, -1, -1 };
        BinaryTree tree2 = new BinaryTree();
        Node root2 = tree2.buildTree(nodes2);
        /*
         * 2
         * / \
         * 4 5
         * 
         */

        // System.out.println(tree1.isSubtree(root1, root2));
        // tree1.topView(root1);
        // tree1.kthLevel(root1, 1, 3);
        // System.out.println(tree1.lowestCommonAncestor(root1, 4, 5).data);
        // System.out.println(tree1.lca2(root1, 4, 7).data);
        // System.out.println(tree1.min_Distance(root1, 4, 7));
        tree1.kthAncestor(root1, 5, 2);
    }
}
