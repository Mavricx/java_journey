package Java_Core_Concepts.Binary_Trees;
//  Definition for a binary tree node.
public class IsSameTreeOrIsSymmetric {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Question 1
    // Here two approaches two check the same tree or not
    // time complexity O(min(m,n)) where m and n are the number of nodes in the two
    // trees.
    // Space complexity O(min(h1,h2)) where h1 and h2 are the heights of the two
    // trees.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // If both are null, it means both trees (or subtrees) are empty → return true.
        // If only one of them is null but not the other → return false.
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
    // Question 2
    // Approach to check the tree is symmetric or not

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);

    }

    public static void main(String[] args) {

    }
}
