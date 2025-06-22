package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Stacks_JCF {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(12);
        st.push(13);
        st.push(45);
        int top = st.pop();
        System.out.println(top);
        System.out.println(st);
    }
}
