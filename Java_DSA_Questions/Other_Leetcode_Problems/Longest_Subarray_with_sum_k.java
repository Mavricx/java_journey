package Java_DSA_Questions.Other_Leetcode_Problems;
import java.util.*;
public class Longest_Subarray_with_sum_k {
   public static int longestSubarrayWithSumk(int arr[] , int k){
    int maxLen=0;
    Map<Integer,Integer> map=new HashMap<>();
    int sum=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(sum==k){
            maxLen=i+1;
        }
        if(map.containsKey(sum-k)){
            maxLen=Math.max(maxLen,i-map.get(sum-k));
        }
        map.put(sum,i);
    }
    return maxLen;
   }   
   public static void main(String[] args) {
    int arr[]={1,-1,5,-2,3};
    int k=3;
    System.out.println(longestSubarrayWithSumk(arr, k)); // Output: 4
   }
}
