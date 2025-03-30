package Java_DSA_Questions.Leetcode75;
// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

// Example 1:

// Input: s = "IceCreAm"

// Output: "AceCreIm"

// Explanation:

// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:

// Input: s = "leetcode"

// Output: "leotcede"

public class Reverse_vowel_of_the_string {

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();

        while (start < end) {
            while (start < end && !isVowel(chars[start])) {
                start++;
            }
            while (start < end && !isVowel(chars[end])) {
                end--;
            }

            if (start < end) {
                swap(chars, start, end);
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Reverse_vowel_of_the_string obj = new Reverse_vowel_of_the_string();
        String s = "IceCreAm";
        System.out.println(obj.reverseVowels(s));
    }

}
