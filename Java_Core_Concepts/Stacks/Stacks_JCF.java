package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Stacks_JCF {

    public static void pushAtButton(Stack<Integer> st, int num) {
        if (st.isEmpty()) {
            st.push(num);
            return;
        }
        int top = st.pop();
        pushAtButton(st, num);
        st.push(top);

    }

    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();// Store the top element
        reverseStack(st);// Recursive call to reverse the remaining stack
        pushAtButton(st, top);// Push the stored element at the bottom
    }

    public static String reverseString(String str) {
        Stack<Character> temp = new Stack<>();
        // int idx = 0;
        // while (idx < str.length()) {
        // temp.push(str.charAt(idx));
        // idx++;
        // }
        for (char ch : str.toCharArray()) {
            temp.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!temp.isEmpty()) {
            reversed.append(temp.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        // pushAtButton(st, 4);
        // System.out.println(st);
        // String str = "Hello World";
        // String reversed = reverseString(str);
        // System.out.println("Original String: " + str);
        // System.out.println("Reversed String: " + reversed);
        reverseStack(st);
        System.out.println(st);
    }
}
