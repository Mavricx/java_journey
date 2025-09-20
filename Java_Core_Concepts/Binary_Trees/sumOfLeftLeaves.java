package Java_Core_Concepts.Binary_Trees;

public class sumOfLeftLeaves {
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


    public int sumOfLeftLeaves1(TreeNode root) {
       return getLeftSum(root,false);
    }
    public static int getLeftSum(TreeNode root, boolean isLeft){
        if (root==null) return 0;

        if(root.left==null && root.right==null) {
            return isLeft?root.val:0;
        }

        int a=getLeftSum(root.left,true);
        int b=getLeftSum(root.right,false);

        return a+b;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        sumOfLeftLeaves tree = new sumOfLeftLeaves();
        System.out.println("Sum of left leaves: " + tree.sumOfLeftLeaves1(root));
    }
}