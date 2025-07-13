package Java_Core_Concepts.Queues;

import java.util.*;

public class Interleave_2_Halves_of_a_Queue {
    public static Queue<Integer> interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int n = q.size();
        for (int i = 0; i < n / 2; i++) {
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);


        q = interleave(q);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }

}
