package Java_DSA_Questions.Other_Leetcode_Problems;

import java.util.*;

public class Decoding_String {

    public static String decodeString(String s) {
        StringBuilder current = new StringBuilder();
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                count.push(k);
                result.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeat = count.pop();
                StringBuilder temp = result.pop();

                for (int i = 0; i < repeat; i++) {
                    temp.append(current);// append current k times
                }
                current = temp; // update current
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
