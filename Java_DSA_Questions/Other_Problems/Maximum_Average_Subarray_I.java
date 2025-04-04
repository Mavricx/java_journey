package Java_DSA_Questions.Other_Problems;
// You are given an integer array nums consisting of n elements, and an integer k.

// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

// Example 1:

// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
// Example 2:

// Input: nums = [5], k = 1
// Output: 5.00000
public class Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        double subSum=0;
        //first window
        for(int i=0;i<k;i++){
            subSum+=nums[i];
        }
        double maxSum=subSum;
        //sliding the window
        for(int i=k;i<nums.length;i++){
            subSum=subSum-nums[i-k]+nums[i];
            maxSum=Math.max(maxSum,subSum);
        }
        return maxSum/k;
    }
    public static void main(String[] args) {
        int nums[]={1,12,-5,-6,50,3};
        int k=4;
        Maximum_Average_Subarray_I obj=new Maximum_Average_Subarray_I();
        System.out.println(obj.findMaxAverage(nums, k));
    }
}
