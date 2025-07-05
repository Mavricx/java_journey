package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Valid_parenthesis {
    public static boolean validParenthesis(String str) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '{' || x == '[') {// opening brackets
                // push the opening brackets onto the stack
                st.push(x);
            } else {
                if (st.isEmpty()) {// if stack is empty and we encounter a closing bracket
                    // it means there is no matching opening bracket
                    return false;
                }
                if ((st.peek() == '(' && x == ')') || (st.peek() == '{' && x == '}')
                        || (st.peek() == '[' && x == ']')) {// if the top of the stack is a matching opening bracket
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
