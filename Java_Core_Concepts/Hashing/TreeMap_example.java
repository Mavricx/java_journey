package Java_Core_Concepts.Hashing;

import java.util.*;

public class TreeMap_example {
    // here keys are sorted.
    // the time complexity of the put get and remove function are O(log n)
    // here the no array or linked list in used 
    // instead here "Red Black Trees" are used.
    // RED BLACK TREES is a special type of self balancing BST.

    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(21, "harish");
        tm.put(32, "Gokul");
        tm.put(34, "Radhe Shyam");
        tm.put(24, "khitish");

        System.out.println(tm);//sorted 21 ->24 ->32 ->34 
    }

}
