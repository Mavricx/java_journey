package List_Implemented_Classes;
import java.util.LinkedList;
import java.util.Stack;
public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        //if we want to store the value of pop then 
      //  Integer removedElement=stack.pop();
        //System.out.println("Removed element: " + removedElement);

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());


       //adding the element in the middle of stack
       stack.add(1,56);//this is possible because the stack is extending the vector class

       int search=stack.search(3);
       System.out.println(search);//returns  -1 as it is not present in the stack
       
       
       //using the linkedlist as stack
       LinkedList <Integer> ll=new LinkedList<>();
       ll.addLast(2);
       ll.addLast(44);
       ll.addLast(45);//push equivalent
       ll.getLast();//peek equivalent
       ll.removeLast();//pop equivalent

    }
}




