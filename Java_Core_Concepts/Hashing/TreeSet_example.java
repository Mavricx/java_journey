package Java_Core_Concepts.Hashing;
import java.util.*;
public class TreeSet_example {
    // sorted order in ascending order.
    // no null elements are allowed.
    // provides guaranteed log(n) time cost for the basic operations (add, remove and contains)
    //example
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
        // set.add(null); // This will throw NullPointerException
        System.out.println(set.contains("apple"));
        set.remove("banana");
        System.out.println(set);
    }
}
