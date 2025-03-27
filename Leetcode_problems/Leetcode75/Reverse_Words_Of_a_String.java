// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"
// Example 2:

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
public class Reverse_Words_Of_a_String {
    public static String reverseWords(String s) {
        s=s.trim();
        StringBuilder sb = new StringBuilder();
        String words[]=s.split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s)); // Output: "world hello"
        String s1 = "a good   example";
        System.out.println(reverseWords(s1)); // Output: "example good a"
        String s2 = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s2)); // Output: "Alice Loves Bob"
        String s3 = "Alice does not even like bob";
        System.out.println(reverseWords(s3)); // Output: "bob like even not does Alice"
    }
}
