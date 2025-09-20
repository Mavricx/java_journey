package Java_Core_Concepts.Binary_Trees;

public class InvertTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public Node invertTree(Node root) {
        invert(root);
        return root;
    }

    public void invert(Node root){
        if(root==null) return ;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
    
}
