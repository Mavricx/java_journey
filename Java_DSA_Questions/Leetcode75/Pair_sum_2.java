package Java_DSA_Questions.Leetcode75;

import java.util.ArrayList;
import java.util.Arrays;

// Find if any pair in a sorted and rotated arraylist has a target sum.
//prefer the diagrams to understand the movement of the pointers.
public class Pair_sum_2 {

    public static boolean isThere(ArrayList<Integer> list, int target) {
        int pivot = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i + 1) < list.get(i)) {
                pivot = i;
                break;
            }
        }

        int left = pivot + 1;
        int right = pivot;
        while (left != right) {
            if (list.get(left) + list.get(right) == target) {
                return true;
            }
            if (list.get(left) + list.get(right) < target) {
                left = (left + 1) % n; // use modular arithmetics.

            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 15, 6, 8, 9, 10));
        System.out.println(isThere(list, 16));
    }
}
