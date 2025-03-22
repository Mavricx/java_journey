
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

public class Move_zero_to_left {
    public void moveZeroes(int[] nums) {
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=0){//if current element is not zero
                int temp=nums[fast];//now swap along the array to get non-zero element to left
                nums[fast]=nums[slow];
                nums[slow]=temp;
                slow++;
            }
        }
        
    }
    public static void main(String[] args) {
        Move_zero_to_left obj = new Move_zero_to_left();
        int[] nums = {0,1,0,3,12};
        obj.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
}
