package Java_Core_Concepts.Hashing;

import java.util.*;

public class HashSet_example {
    // no duplicates
    // unordered
    // Null is allowed
    // all functions add, contains, remove, size  have constant time complexity O(1)
    // hash set is implemented using hashmap.
    // similarly linked Hashset is implemented by linked hashmap
    // and tree set is implemented by tree map.
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add(null);
        System.out.println(set.contains("apple"));
        set.remove("banana");
        //again adding apple (duplicate)
        set.add("apple");//only added/shows once 
     
        // System.out.println(set);
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());
        // set.clear();
        // System.out.println(set);
        // System.err.println(set.isEmpty());

        //how to iterate along a hashset
        //two ways : 1.using iterators
                   //2.using enhanced for loop


        //using iterators
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //using enhanced for loop
         for(String fruit:set){
            System.out.println(fruit);
         }
    }

}
