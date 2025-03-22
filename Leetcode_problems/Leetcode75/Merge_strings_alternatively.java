// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

// Return the merged string.

 

// Example 1:

// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r
// Example 2:

// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b 
// word2:    p   q   r   s
// merged: a p b q   r   s

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder("");
        int l1=word1.length();
        int l2=word2.length();
        int i=0;
        while(i<l1 || i<l2 ){
        if(i<l1){
            sb.append(word1.charAt(i));  
        }
        if(i<l2){
            sb.append(word2.charAt(i));    
        }
        i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution obj=new Solution();
        String word1="abc";
        String word2="pqr";
        System.out.println(obj.mergeAlternately(word1, word2));
    }
}