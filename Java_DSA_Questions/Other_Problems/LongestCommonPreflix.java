package Java_DSA_Questions.Other_Problems;
//Answer to the question https://leetcode.com/problems/longest-common-prefix/description/

import java.util.Arrays;

class LongestCommonPreflix {
    public String longestCommonPrefix(String[] strs) {
         StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i] + " ");
        }
    }
}
