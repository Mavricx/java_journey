package Java_DSA_Questions.Other_Problems;

public class Find_Duplicate_Number {
    // Given an array of integers nums containing n + 1 integers where each integer
    // is in the range [1, n] inclusive.

    // There is only one repeated number in nums, return this repeated number.

    // You must solve the problem without modifying the array nums and using only
    // constant extra space.

    // Example 1:
    // Input: nums = [1,3,4,2,2]
    // Output: 2


    // Example 2:
    // Input: nums = [3,1,3,4,2]
    // Output: 3


    // Example 3:
    // Input: nums = [3,3,3,3,3]
    // Output: 3
 

    //approach
    // 1. Use Floyd's Tortoise and Hare (Cycle Detection) algorithm.
    // fast and slow pointers
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // until they meet fast moves two steps ahead and slow move one step at a time .
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow)
                break;
        }
        //once met set slow to 0 again 
        //now both move one step at a time until they meet again
        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 4, 2, 2 };
        int[] nums2 = { 3, 1, 3, 4, 2 };
        int[] nums3 = { 3, 3, 3, 3, 3 };
        Find_Duplicate_Number finder = new Find_Duplicate_Number();
        System.out.println(finder.findDuplicate(nums1)); // Output: 2
        System.out.println(finder.findDuplicate(nums2)); // Output: 3
        System.out.println(finder.findDuplicate(nums3)); // Output: 3
    }
}
