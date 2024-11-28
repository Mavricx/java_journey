package Common_java_problems;
public class SortingFunctions {

    public static void arrPrint(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void bubbleSort(int arr[]) {// bubble sort
        for (int turn = 0; turn < arr.length - 1; turn++) { // choose an element from 1st
            for (int i = 0; i < arr.length - 1 - turn; i++) {// keep checking the element's rightful place.
                if (arr[i] > arr[i + 1]) {// check if current element is bigger than the upward element.
                    // swap if fulfills the condition.
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;

                }
            }
        }
    }

    public static void selectionSort(int arr[]) { // selection sort.
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {// only run from end of sorted array.
                if (arr[j] < arr[minPos]) {
                    minPos = j; // find the smallest element in the unsorted array.
                }

            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {// start from 2nd element.
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {// run this until the current element hasn't found its correct place.
                arr[prev + 1] = arr[prev]; // push bigger element upward.
                prev--;// go downward to check again.
            }
            arr[prev + 1] = curr;// place current element just after the checked element.
        }
    }

    public static void quickSort(int l, int h, int[] arr) {// not working properly
        if (l < h) {
            int j = partition(l, h, arr);
            quickSort(l, j, arr);
            quickSort(j + 1, h, arr);
        }

    }

    public static int partition(int l, int h, int[] arr) {

        int pivot = arr[l];
        int i = l;
        int j = h;
        while (i < j) {
            do {
                i++;
            } while (arr[i] > pivot);
            do {
                j--;
            } while (arr[j] < pivot);
            if (i < j) {
                swap(arr[i], arr[j]);
            }

        }
        swap(arr[l], arr[j]);
        return j;
    }

    public static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 6, 2, 5, 7, 1, Integer.MAX_VALUE };
        quickSort(0, arr.length, arr);
        arrPrint(arr);

    }
}
