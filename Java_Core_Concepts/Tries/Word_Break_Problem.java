package Java_Core_Concepts.Tries;

public class Word_Break_Problem {
    // Word Break Problem
    // Given an input string and a dictionary of words, find out if the input string
    // can be broken into a space-separated sequence of dictionary words.
    // words[]= {i, like, sam, samsung, mobile, ice}
    // key "ilikesamsung"
    // output: true

    // approach
    // 1. Insert all dictionary words into the Trie.
    // 2. Use backtracking to find if the key can be segmented into dictionary
    // words.

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;// end of word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static Node root = new Node();

    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void insert(String word) {// time complexity : O(L) where L is the length of longest word.
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];

        }
        curr.eow = true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // subString(0,i)
            String left = key.substring(0, i);
            String right = key.substring(i);
            if (search(left) && wordBreak(right)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String key = "ilikesamsung";
        for (String word : words) {
            insert(word);
        }
        System.out.println(wordBreak(key));
        System.out.println(wordBreak("ilikesung"));
    }
}
