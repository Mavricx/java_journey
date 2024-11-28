public class QuickSort {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    public static void quickSort(int arr[], int si, int ei) {  //approach is for last element as pivot element
        if (si >= ei) {
            return;
        }
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx - 1);
        quickSort(arr, pidx + 1, ei);

    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;// to make place for element small tha pivot
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) { //placing all smaller elements in the begining of the array in this loop
                // swap
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        int temp = pivot; // placing pivot in its position after placing all te small elements.
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, -1 };
        System.out.print("Before sorting : ");
        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.print("After sorting: ");
        printArr(arr);
    }
}
// the worst case occur in quicksort if the pivot is smallest element or the
// largest element i.e O(n^2)
// average time complexity is O(nlogn).