package Java_Core_Concepts.Hashing;

import java.util.*;

public class Find_Itinerary_from_Tickets {
    // "Chennai" -> "Bengaluru"
    // "Mumbai" -> "Delhi"
    // "Goa" -> "Chennai"
    // "Delhi" -> "Goa"
    //
    //
    // ans : "Mumbai"-> "Delhi"-> "Goa" -> "Chennai" -> "Benagluru"

    // Approach
    // 1. Create a HashMap to store the tickets
    // 2. Find the starting point (the ticket that is not a destination)
    // 3. Construct the itinerary by following the tickets from the starting point

    public static String getStart(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key: map.keySet()){
            revMap.put(map.get(key),key);
        }

        for(String key: map.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        String start =getStart(map);
        System.out.print(start);
        for(String key:map.keySet()){
            System.out.print("-> "+map.get(start));
            start=map.get(start);
        }


    }

}