package Java_Core_Concepts.Hashing;

import java.util.*;

public class LinkedHashMap_example {
    // LinkedHashMap is where keys are in insertion ordered
    // here doubly linked list are used instead of singly linked list which makes the keys ordered.
    // other function and time complexity  are similar to the normal hashmap
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("india", 100);
        lhm.put("china", 150);
        lhm.put("us", 50);

        System.out.println(lhm);
    }
}
