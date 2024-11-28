public class MergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    public static void mergeSort(int arr[], int si, int ei) { // just divides the array in two again and again by
                                                              // recurssion
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) { // for merging two array in sorted manner(both
                                                                   // merging and sorting)
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) { // add elements in sorting order as long as both has elements
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            } 
            k++;
        }
        while (i <= mid) { // for the remaining elements from the previous loop
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) { // copying from the temp array to the arr array
            arr[i] = temp[k];
        }

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        System.out.print("Before sorting : ");
        printArr(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("After sorting: ");
        printArr(arr);
    }
}
// Time Complexity for this program is O(nlogn)
// Space Complexity for this program is O(n)
