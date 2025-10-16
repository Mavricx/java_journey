package Java_DSA_Questions.Other_Leetcode_Problems;

import java.util.HashSet;

public class Longest_consecutive_sequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
               int length=0;

                while(set.contains(num+length)){
                   length++;
                }
                longest=Math.max(length,longest);
            }  
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums)); // Output: 4
    }
}
