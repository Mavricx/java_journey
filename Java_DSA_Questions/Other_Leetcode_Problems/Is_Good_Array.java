package Java_DSA_Questions.Other_Leetcode_Problems;

import java.util.HashMap;
import java.util.Map;

public class Is_Good_Array {
     public static boolean isGood(int[] nums) {
        int n=0;
        //get the maximum number present
        for(int num:nums){
            if(num>n) n=num;
        }
        //if length matches base[n] i.e n+1
        if(nums.length!=n+1) return false;

        //count frequencies
        Map<Integer,Integer> count=new HashMap<>();
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        //verify frequencies for 1 to n
        for(int i=1;i<n;i++){
            if(count.getOrDefault(i,0)!=1) return false;
        }
        //make sure n appears twice
        if(count.getOrDefault(n,0)!=2) return false;
        
        //no extra element allowed.
        for(int key:count.keySet()){
            if(key<1 || key>n) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,3,4};
        System.out.println(isGood(nums)); // Output: true
    }
}
