package List_Implemented_Classes;
import java.util.Arrays;
import java.util.Vector;
import java.util.LinkedList;
public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(5); // Create a Vector of Integer type
        System.out.println(vector.capacity()); // Print the initial capacity of the vector which is 10 by default
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println(vector.capacity()); // Print the capacity after adding 5 elements
        vector.add(6); // Adding one more element to exceed the initial capacity
        System.out.println(vector.capacity()); // Print the capacity after exceeding the initial capacity
        //capacity doubles when it exceeds the initial capacity
        //but when you want to increase the capacity of the vector by a specific number, you can use give another argument during vector declaration
        // Vector<Integer> vector = new Vector<>(5, 3); // Initial capacity of 5 and increment of 3 
        Vector <Integer> vector1=new Vector<>(Arrays.asList(2,3,4));


        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        Vector<Integer> vector2=new Vector<>(linkedList);//passing  linkedlist to vector constructor
        System.out.println(vector2);
    }
}
