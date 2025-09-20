package Java_Core_Concepts.Binary_Trees;
public class CheckIsBalanced {
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
        
    public int checkHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight=checkHeight(root.left);
        if(leftHeight==-1) return -1;
        int rightHeight=checkHeight(root.right);
        if(rightHeight==-1) return -1;
        
        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight,rightHeight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!=-1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.right.right = new TreeNode(7);

        CheckIsBalanced tree = new CheckIsBalanced();
        System.out.println("Is the tree balanced? " + tree.isBalanced(root));
    }
}
