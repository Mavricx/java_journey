package Java_DSA_Questions.Leetcode75;
// For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

// Example 1:

// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Example 2:

// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"
// Example 3:

// Input: str1 = "LEET", str2 = "CODE"
// Output: ""

public class Greatest_common_divisor_of_strings {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){//only if the two strings are not in correct format.
            return "";
        }
        int lengthGcd=gcd(str1.length(), str2.length());
        return str1.substring(0,lengthGcd);
    }
    public int gcd(int x, int y){
        if(x%y==0) return y;
        else return gcd(y, x%y);
    }
    public static void main(String[] args) {
        Greatest_common_divisor_of_strings obj=new Greatest_common_divisor_of_strings();
        String str1="ABCABC";
        String str2="ABC";
        System.out.println(obj.gcdOfStrings(str1, str2));
    }
}