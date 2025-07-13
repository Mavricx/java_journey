package Java_Core_Concepts.Queues;

import java.util.*;

public class First_Non_Repeating_Char_From_Stream_of_Chars {

    public static void nonRepeatingChars(String str) {
        Queue<Character> chars = new LinkedList<>();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars.add(ch);
            freq[ch - 'a']++;

            while (!chars.isEmpty() && freq[chars.peek() - 'a'] > 1) {
                chars.remove();
            }

            if (chars.isEmpty()) {
                System.err.print(-1 + " ");
            } else {
                System.out.print(chars.peek() + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        nonRepeatingChars(str);
    }

}
