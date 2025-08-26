package Java_Core_Concepts.Tries;

public class Prefix_problem {
    // Prefix Problem
    // Find shortest unique prefix for every word in a given list.
    // Assume no word is prefix of another.
    // arr[] = ("zebra", "dog", "duck", "dove")
    // ans : ("z", "dog", "du", "dov")

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;// end of word
        int freq=1;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static Node root = new Node();

    public static void insert(String word) {// time complexity : O(L) where L is the length of longest word.
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
                curr.freq++;                  //slightly modified.
            }
            curr = curr.children[idx];

        }
        curr.eow = true;
    }

    public static String findUniquePrefix(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                break;
            }
            curr = curr.children[idx];
            prefix.append(word.charAt(level));
            if (curr.freq == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for (String word : arr) {
            insert(word);
        }
        for (String word : arr) {
            System.out.println(word + " : " + findUniquePrefix(word));
        }
    }
}
