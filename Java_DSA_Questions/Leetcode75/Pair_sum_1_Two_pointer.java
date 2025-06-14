package Java_DSA_Questions.Leetcode75;

import java.util.ArrayList;
import java.util.Arrays;

public class Pair_sum_1_Two_pointer {

    public static boolean isThere(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left != right) {
            if (list.get(left) + list.get(right) == target) {
                return true;
            }
            if (list.get(left) + list.get(right) < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(isThere(list,5));
    }
}
