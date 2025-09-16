package Java_Core_Concepts.Queues;

import java.util.Stack;

public class Queue_Stacks {

    //approach
    // We will use two stacks to implement the queue
    // s1 and s2
    // for add operation we will push the element in s1
    // for remove and peek operation we will check if s2 is empty
    // if s2 is empty we will pop all the elements from s1 and push them in s2
    // then we will pop or peek the element from s2
    // if s2 is not empty we will directly pop or peek the element from s2
    // this way we can implement the queue using stacks
    // time complexity of add operation is O(n) in worst case
    // time complexity of remove and peek operation is O(1) in average case
    static class Queue1 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // only thing worth noticing
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }


    
    public static void main(String[] args) {
        Queue1 q = new Queue1();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
