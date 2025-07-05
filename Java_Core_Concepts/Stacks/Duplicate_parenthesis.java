package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Duplicate_parenthesis {

    public static boolean checkDuplicate(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // case for closing brackets
            if (ch == ')') {
                int count = 0;
                while (stack.pop() != '(') {// pop elements until we find the matching opening bracket
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            } else {
                stack.push(ch);// push the character onto the stack if it is not a closing bracket
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String expression = "((a+b)+(c+d))";
        if (checkDuplicate(expression)) {
            System.out.println("Duplicate parenthesis found");
        } else {
            System.out.println("No duplicate parenthesis found");
        }

    }
}
