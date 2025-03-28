package Java_Collection_Framework.Map;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(); // Create a HashMap
        map.put(1, "Allen");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        System.out.println(map);
        System.out.println(map.get(3));
        // or
        String studentName = map.get(2);
        System.out.println(studentName);

        // Check if a key exists
        if (map.containsKey(2)) {
            System.out.println("Key 2 exists in the map.");
        } else {
            System.out.println("Key 2 does not exist in the map.");
        }
        // Check if a value exists
        if (map.containsValue("Bob")) {
            System.out.println("Value 'Bob' exists in the map.");
        } else {
            System.out.println("Value 'Bob' does not exist in the map.");
        }

        // Remove a key-value pair
        map.remove(2);
        System.out.println("After removing key 2: " + map);

        //to store the keys in a set
        Set<Integer> keys = map.keySet();

        //to iterate through the keys
        for (Integer key :  map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        //another way to iterate through the map 
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for(Map.Entry<Integer,String> entry:entrySet){
            entry.setValue(entry.getValue().toUpperCase());//making it to uppercase
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
           
        }
    }
}
