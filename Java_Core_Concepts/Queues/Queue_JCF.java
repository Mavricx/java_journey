package Java_Core_Concepts.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Queue in java collection framework is not a class but a interface & we can't
        // make objects of interface but we can make objects of class implementing this
        // interface i.e queue.

        //Two classes implements queue 1>LinkedList and 2> ArrayDeque
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
