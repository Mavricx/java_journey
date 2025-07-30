import java.util.*;

public class HeapSort {
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int maxIdx = i;
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {

        // time complexity:O(nlogn)
        // if we want ascending order --> build max heap
        // if we want descending order -->build min heap

        // step-1: call heapify for non-leaf nodes.(i.e from n/2 to zero) to build a max
        // heap.
        // step-2: take largest element and push it to the end (swap with last.) remove
        // the largest from earlier and call heapify for root.
        // step-3: repeat the step-2

        int n = arr.length;
        // step-1: build max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step-2
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);

        for (int a : arr) {
            System.out.println(a + " ");
        }
    }
}
