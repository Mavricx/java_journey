package Java_DSA_Questions.Other_Leetcode_Problems;
public class Good_subarray {
//A “good subarray” is defined as a contiguous subarray where the sum of all elements is divisible by the length of that subarray.

// Task:
// Find the length of the longest good subarray.
    public static int maxGoodSubarraySize(int [] nums){
        int n=nums.length;
        int [] prefix=new int[n];
        
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }

        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=prefix[j+1]-prefix[i];//sum of subarray from i to j
                int len=j-i+1;

                if(sum%len==0){
                    maxLen=Math.max(maxLen,len);
                }
            }
        }
        return maxLen;
    }
}
