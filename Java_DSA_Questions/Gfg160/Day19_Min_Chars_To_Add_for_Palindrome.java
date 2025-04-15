package Java_DSA_Questions.Gfg160;

public class Day19_Min_Chars_To_Add_for_Palindrome {
    public static int[] computeLPS(String s) {
        int lps[] = new int[s.length()];
        int length = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static int minChar(String s) {
        // Write your code here
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = computeLPS(combined);
        return s.length() - lps[lps.length - 1];
    }
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(minChar(s)); // Output: 4 (characters to add to make it a palindrome)
        
        String s2 = "aacecaaa";
        System.out.println(minChar(s2)); // Output: 1 (add 'a' at the beginning)
        
        String s3 = "abcd";
        System.out.println(minChar(s3)); // Output: 3 (add 'dcb' at the beginning)
    }
}
