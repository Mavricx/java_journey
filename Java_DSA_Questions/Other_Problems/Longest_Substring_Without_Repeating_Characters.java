package Java_DSA_Questions.Other_Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lswrc_brute(String str) {
        int n = str.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            boolean seen[] = new boolean[128];//assuming the input string contains only ASCII characters.
            for (int j = i; j < n; j++) {
                if (seen[str.charAt(j)])
                    break;
                seen[str.charAt(j)] = true;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static int lswrc_set(String str) {
        int n = str.length();
        int maxLen = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            char c = str.charAt(right);
            while (set.contains(c)) {//here we use while because we need to remove all the characters till the repeating character is removed.
                set.remove(str.charAt(left));
                left++;//move the left pointer to the right/ shrink the window from the left side.
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int lswrc_map(String str) {
        int n = str.length();
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char c = str.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {//important to check if the index is in the current window.
                left = map.get(c) + 1;// move the left pointer to the next of the previous index of the repeating character
                //jump right to left+1 if the repeating character is already in the current window.
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lswrc_brute(str));
        System.out.println(lswrc_set(str));
        System.out.println(lswrc_map(str));
    }
}
