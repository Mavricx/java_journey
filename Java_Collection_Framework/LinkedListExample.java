import java.util.LinkedList;
import java.util.Arrays;

class Node{
    int val;
    Node next;
    Node(int x){
       this.val=x;
    }
     Node(int x, Node next){
        val=x;
        this.next=next;
     }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.addFirst(0);//O(1) time complexity
        linkedList.addLast(5);//O(1) time complexity
        linkedList.add(2, 10);//O(n) time complexity

        // linkedList.remove(3);
        // System.out.println(linkedList.removeFirst());
        // System.out.println(linkedList.removeLast()); 

        // System.out.println(linkedList.get(3)); //O(n) time complexity
        // System.out.println(linkedList.getFirst());//O(1) time complexity
        // System.out.println(linkedList.getLast());//O(1) time complexity

        //predicate
        linkedList.removeIf(x ->x%2==0);

        System.out.println(linkedList);


        LinkedList<String> animals=new LinkedList<>(Arrays.asList("cat", "dog", "rabbit", "fox"));
        LinkedList<String> animalsToRemove=new LinkedList<>(Arrays.asList( "rabbit", "fox"));
        animals.removeAll(animalsToRemove);//removes all elements from animals that are in animalsToRemove
        System.out.println(animals);
        
    }
}
