package Java_Core_Concepts.Queues;

public class Queue_Array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;

        }

        // isEmpty()
        public boolean isEmpty() {
            return rear == -1;
        }

        // add()
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        // remove with O(n) time complexity.
        public int remove() {
            if (isEmpty()) {
                System.out.println("The queue is empty.");
                return -1;
            }
            int front = arr[0];
            rear = rear - 1;
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("The queue is empty.");
                return -1;
            }
            return arr[0];
        }

    }

    static class Circular_Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Circular_Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            front = (front + 1) % size;
            return arr[front];
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[(front + 1) % size];
        }

    }

    public static void main(String[] args) {
        // Queue q = new Queue(5);
        // q.add(4);
        // q.add(5);
        // q.add(1);

        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        Circular_Queue cq = new Circular_Queue(5);
        cq.add(1);
        cq.add(2);
        cq.add(3);

        System.out.println(cq.remove());
        cq.add(4);
        System.out.println(cq.remove());
        cq.add(5);

        while (!cq.isEmpty()) {
            System.out.println(cq.peek());
            cq.remove();
        }
    }
}
// disadvantages
// -->Fixed size
// ->Remove operation take O(n) time complexity.