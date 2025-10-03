package Java_DSA_Questions.Other_Leetcode_Problems;

public class Longest_Palindromic_Substring {
    //this algorithm is called "Manacher's Algorithm"
     public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        for(int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);

            // Update the start and end indices of the longest palindrome found
            if(len>end-start){
                //why this formula?
                //for odd length palindrome, len=2*L+1 => L=(len-1)/2
                //for even length palindrome, len=2*L => L=len/2
                //so we can combine both cases into one formula
                start=i-(len-1)/2;//for odd length palindrome
                end=i+len/2;//for even length palindrome
            }
        }
        return s.substring(start,end+1);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
