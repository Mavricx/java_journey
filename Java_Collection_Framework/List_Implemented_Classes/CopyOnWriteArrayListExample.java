package List_Implemented_Classes;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class CopyOnWriteArrayListExample {
    
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cowArrayList = new CopyOnWriteArrayList<>();
        //"copy on write " mean that whenever a write a operation 
        //like adding or removing an element 
        //instead of directly modifying the existing list
        //a new copy of the list is created , and the modification is applied to the that copy
        //this ensures that other threads reading the list while it's being modified are unaffected

        //For read Operations: Fast and direct , since they happen on a stable list without interference from modifications
        //For write Operations: Slower, as they involve creating a new copy of the list for every modification
                             //The reference to the list is then updated so that subsequent reads use this new list.


        //lets try something interesting
        List<String> list = new ArrayList<>();
        list.add("Milk");
        list.add("Eggs");
        list.add("Bread");
        list.add("Butter");
        System.out.println("Original List: " + list);
        
        for(String item:list){
            System.out.println("Item: " + item);
            if(item.equals("Eggs")){
                //adding the item when the loop is running/reading the list
                list.add("Butter"); // this will throw ConcurrentModificationException
                System.out.println("Added Butter while reading");
            }
        }
        //once this loop ends the new reference of the list will be updated or modified
        //This will throw ConcurrentModificationException
        //To avoid this we can use CopyOnWriteArrayList

    }
}
