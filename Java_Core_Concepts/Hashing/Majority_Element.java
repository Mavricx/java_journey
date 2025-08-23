package Java_Core_Concepts.Hashing;

import java.util.*;

public class Majority_Element {
    // Given an integer array of size n, find all elements that appear more than I
    // n13 J times.
    // nums[] ={1, 3, 2, 5, 1, 3, 1, 5, 1};
    // ans:1 (four time present)

    // for array {1,2} and n/3=2/3=0 then
    // ans =1,2

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : hm.keySet()) {
            if (hm.get(key) > n / 3) {
                ans.add(key);
            }
        }
        System.out.println(ans);

    }
}
