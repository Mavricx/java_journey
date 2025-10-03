package Java_DSA_Questions.Other_Leetcode_Problems;

import java.util.HashMap;

public class Majority_elements {

    public int majorityElement_naive_approach(int []nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==nums[i]){
                    count++;
                }
            }
            if(count>n/2){
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement_Better_approach(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> res=new HashMap<>();
        for(int i=0;i<n;i++){
            res.put(nums[i],res.getOrDefault(nums[i],0)+1);
        }

        for(Integer count:res.keySet()){
            if(res.get(count)>n/2){
            return count;
            }          
        }
        return -1;
    }
    
    public int majorityElements_Optimal_approach(int[] nums){//also called moore's voting algorithm
    int n=nums.length;
    int element=nums[0];//starts with the first element and the count is 1
    int count=1;
    for(int i=1;i<n;i++){
        if(count==0){//if in any case count becomes zero then element take the value of next element
            element=nums[i];
            count=1;//and resets the count
        }
        else if(nums[i]==element){//if the element occurs again then count increases
            count++;
        }
        else{//for any other element it decreases
            count--;
        }
    }
    //at last the element remains after cancelling out the rest of the element
    int counter=0;
    for(int i=0;i<n;i++){//this is double checking the result
        if(nums[i]==element){//we check this if there is a probability of not geting the majority element
            counter++;
        }
    }
    if(counter>n/2){
        return element;
    }
    return -1;
    }
    public static void main(String[] args) {
        Majority_elements obj = new Majority_elements();
        int[] nums = {2, 2, 1, 1, 1, 2, 2}; // Example input
        System.out.println("Naive Approach: " + obj.majorityElement_naive_approach(nums)); // Output: 2
        System.out.println("Better Approach: " + obj.majorityElement_Better_approach(nums)); // Output: 2
        System.out.println("Optimal Approach: " + obj.majorityElements_Optimal_approach(nums)); // Output: 2
    }
}
