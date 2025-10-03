package Java_DSA_Questions.Other_Leetcode_Problems;
//Answer to the question https://leetcode.com/problems/valid-parentheses/
import java.util.Stack;

class Valid_parenthesis {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }

            else if (s.charAt(i) == ')' && st.peek() == '(') {
                st.pop();
            } else if (s.charAt(i) == '}' && st.peek() == '{') {
                st.pop();
            } else if (s.charAt(i) == ']' && st.peek() == '[') {
                st.pop();
            }

        }
   
        return (st.isEmpty());
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));
    }
}