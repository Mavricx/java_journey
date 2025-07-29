
import java.util.*;

public class Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add the new data into the heap
            arr.add(data);
            // then fix the heap by swapping the parent and child until its correct.
            // as we know child index=2*parent index+1
            int x = arr.size() - 1;// this is the index of child
            int par = (x - 1) / 2;
            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {//
            // also means get minimum in a mean heap and get max heap in max heap.
            if (arr.isEmpty()) {
                System.out.println("The heap is empty");
                return -1;
            }
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }
            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {// time complexity O(1);
            // three steps to remove or delete a element in a heap
            // step-1: swap the first and last element of heap
            // step-2: remove the last element
            // step-3: heapify the heap.

            // what is heapify ?//the process of making it a heap again.
            // call heapify for the root node recursively
            // it compares its left node and right node's value and get minimum value among
            // root and left and right
            // swap the minimum value with putting the minimum value at root node

            // get the data
            int data = arr.get(0);
            // swap the first and last
            int temp = data;
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}