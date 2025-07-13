package Java_Core_Concepts.Queues;

import java.util.*;

public class Double_Ended_Queue {
    // this is also called Deque.
    // double ended queue.
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(23);
        deque.addLast(45);
        deque.addFirst(12);
        deque.addLast(67);
        System.out.println("Deque after adding elements: " + deque);
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());
    }
}
