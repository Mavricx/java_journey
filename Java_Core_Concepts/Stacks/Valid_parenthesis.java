package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Valid_parenthesis {
    public static boolean validParenthesis(String str) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                st.push(x);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if ((st.peek() == '(' && x == ')') || (st.peek() == '{' && x == '}')
                        || (st.peek() == '[' && x == ']')) {
                    st.pop();
                } else {
                    return false;
                }

            }

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({[]}())";
        System.out.println(validParenthesis(str));

    }
}
