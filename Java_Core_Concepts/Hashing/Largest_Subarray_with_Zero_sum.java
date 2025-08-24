package Java_Core_Concepts.Hashing;

import java.util.HashMap;

public class Largest_Subarray_with_Zero_sum {
    // Find the size of largest subarray with a sum of zero
    // arr[]={-2,2,-8,1,7,10,23}
    // ans: 5 (sub array: {-2,2,-8,1,7})

    // for array : {3,4,5}
    // ans : 0 (null)

    // Approach explained in simple steps:
    // 1. Use a HashMap to keep track of the sum of elements from the start up to
    // each index (cumulative sum) and where that sum first appears.
    // 2. Go through each element in the array, adding it to a running total (the
    // cumulative sum).
    // 3. If at any point the cumulative sum is zero, it means the subarray from the
    // start to this index adds up to zero, so update the maximum length.
    // 4. If the same cumulative sum has been seen before (exists in the HashMap),
    // it means the elements between the previous index and the current index sum to
    // zero. Update the maximum length if this subarray is longer.
    // 5. If the cumulative sum is new, store it in the HashMap with its index.
    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println("Maximum size of zero sum subarray: " + maxLength);

    }
}
