package Java_DSA_Questions.Leetcode75;
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false
public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int si=0;
        int ti=0;
        while(si<s.length() && ti<t.length()){
            if(s.charAt(si)==t.charAt(ti)){
                si++;
            }
            ti++;
        }
        return si==s.length();
    }
    public static void main(String[] args) {
        Is_Subsequence obj=new Is_Subsequence();
        String s="abc";
        String t="ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
    }
}
