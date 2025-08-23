package Java_Core_Concepts.Hashing;

import java.util.HashMap;

// Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
// s = "race" t="care"
// s = "heart" t = "earth"
// s = "tulip" t = "lipid"
// TRUE
// TRUE
// FALSE
public class Valid_Anagrams {

    public static void main(String[] args) {
        String s = "race";
        String t = "care";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                System.err.println("Not an anagram");
                break;
            }
            if (map.get(t.charAt(i)) == 0) {
                map.remove(t.charAt(i));
            }
        }
        if (map.isEmpty()) {
            System.out.println("This is an anagram.");
        }

    }
}
