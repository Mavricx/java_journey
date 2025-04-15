package Java_DSA_Questions.Gfg160;

import java.util.ArrayList;

public class Day18_Search_Pattern_KMP {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] lps = computeLPSArray(pat);
        int i = 0, j = 0;
        while (i < txt.length()) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == pat.length()) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < txt.length() && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    public static int[] computeLPSArray(String pat) {
        int lps[] = new int[pat.length()];
        int len = 0;
        int i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Day18_Search_Pattern_KMP obj = new Day18_Search_Pattern_KMP();
        String pat = "abc";
        String txt = "abcpqrabcxyzabc";
        ArrayList<Integer> result = obj.search(pat, txt);
        System.out.println(result); // Output: [0, 6, 10]
    }
}
