package Java_DSA_Questions.Gfg160;

public class Day10_Kadanes_Algorithm {
    public static int maxSubarraySum(int[] arr) {
        // Your code here
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            
            sum+=arr[i];
            
            maxSum=Math.max(sum,maxSum);
            
            sum =(sum < 0) ? 0 : sum;//if sum is a negative number then we will reject the left part of the array as the part of subarray
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarraySum(arr));
    }
}
