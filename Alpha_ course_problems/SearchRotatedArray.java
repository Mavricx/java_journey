public class SearchRotatedArray {
    //question is to search an element in a rotated and sorted array
    public static int search(int arr[], int si, int tar, int ei) {
        int mid = si + (ei - si) / 2;
        // case found on mid
        if (arr[mid] == tar) {
            return mid;
        }
        // mid on l1
        if (arr[si] <= arr[mid]) {
            // case A: left side of the mid point
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, si, tar, mid - 1);
            }
            // case B:right of the the mid point
            else {
                return search(arr, mid + 1, tar, ei);
            }
        }
        // mid on l2
        else {
            // case C:right of the mid point
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, mid + 1, tar, ei);
            }
            // cade D:left of the mid point
            else {
                return search(arr, si, tar, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 }; // rotated array
        int target = 0;// searching for zero in array
        System.out.println(search(arr, 0, target, arr.length - 1));
    }
}
//time complexity of the searchO(nlogn)
//sort of modified binary search algorithm.

