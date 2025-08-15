package Java_Core_Concepts.Hashing;
import java.util.*;
public class Iteration_on_HashMap {
    public static void main(String[] args) {
    HashMap <Integer,String> hm=new HashMap<>();
    hm.put(12, "Ram");
    hm.put(13,"Utter");
    hm.put(34,"old man");

    //Iterate
    Set<Integer> keyset=hm.keySet();
    System.out.println(keyset);

    for (Integer i : keyset) {
           System.out.println("key = "+i+", value = "+hm.get(i) );
    }
    }
}
