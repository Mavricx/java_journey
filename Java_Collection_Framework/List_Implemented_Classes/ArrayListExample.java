package List_Implemented_Classes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
         ArrayList<Integer> arrayList=new ArrayList<>();
        //we can skip writing <Integer> in the right part / memory allocation part after java 7
        //we can also write this like this as List is ArrayList's parent interface
        //List<Integer> arrayList=new ArrayList<>();


        //adding elements to the arraylist
        arrayList.add(10);
        arrayList.add(28);
        arrayList.add(33);
        // System.out.println(arrayList.get(0));

        for(int i=0;i<arrayList.size();i++){
            // System.out.println(arrayList.get(i));
        }
        
        for(int x:arrayList){
            // System.out.println(x);
        }

        //checking if the arraylist have that element or not
        System.out.println(arrayList.contains(10));
   

        //removing elements from the arraylist
        arrayList.remove(1);//removing the second element

        //if we want to insert one element at a specific index
        arrayList.add(1, 99);

        //if we want to replace one element at a specific index
        arrayList.set(2, 100);

        // System.out.println(arrayList);

        //to convert th list into array
        Object[] arr=arrayList.toArray();
        Integer[] array=arrayList.toArray(new Integer[0]);

        //to sort the arrayList
        Collections.sort(arrayList);
        //or 
        arrayList.sort(null);
}
}
