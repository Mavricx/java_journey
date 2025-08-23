package Java_Core_Concepts.Hashing;

import java.util.*;

public class LinkedHashSet_example {
    // ordered by insertion order using Doubly Linked List
    // maintains a linked list of the entries in the set
    // provides predictable iteration order
    // allows null elements
    // all operations (add, remove, contains) have constant time complexity O(1)

    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add(null);
        System.out.println(set.contains("apple"));
        set.remove("banana");        
        set.add("apple");// only added/shows once

        System.out.println(set);
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());
        // set.clear();
        // System.out.println(set);
        // System.err.println(set.isEmpty());
    }
}
