package Java_Core_Concepts.Priority_Queue;

import java.util.*;

public class Priority_Queue_JFC {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(3);// o(logN):time complexity.
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        // while (!pq.isEmpty()) {
        // System.out.print(pq.peek() + " "); // O(n): Time complexity
        // pq.remove(); // O(logN) :Time complexity.
        // }

        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("Piku", 10));// o(logN):time complexity.
        pq.add(new Student("Hira", 13));
        pq.add(new Student("Lora", 9));
        pq.add(new Student("Jaga", 17));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank); // O(n): Time complexity
            pq.remove(); // O(logN) :Time complexity.
        }

    }
}