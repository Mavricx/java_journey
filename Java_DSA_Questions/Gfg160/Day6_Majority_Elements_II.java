package Java_DSA_Questions.Gfg160;
import java.util.*;
public class Day6_Majority_Elements_II {
    public static List<Integer> majorityElement_brute_force(int[]nums){
        List <Integer> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==nums[i]){
                    count++;
                }
            }
            if(count>n/3 && !res.contains(nums[i])){
               res.add(nums[i]);
            }
        }
        return res;
    }

    public static List<Integer> majorityElement_Better_approach(int[] nums) {
        List <Integer> res=new ArrayList<>();
        int n=nums.length;
        int needForMajority=n/3;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>needForMajority && !res.contains(nums[i])){
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static List<Integer> majorityElements_II_optimal_approach(int []nums){//same moore's majority voting algorithm but with two elements
        //Q.At max how many elements are going to appear in the resulting array?
        //answer 2(always) bcz if elements that appears more than n/3 are more than 2 then 
        //the no.of elements exceedes the size of the array itself.(statement is contractory)
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int needForMajority=n/3;
        int count1=0,count2=0,element1=-100,element2=-343;
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=element2){//during  switching making sure the element1 and element2 are not same
                element1=nums[i];
                count1=1;
            }
            else if(count2==0 && nums[i]!=element1){
                element2=nums[i];
                count2=1;
            }
            else if(nums[i]==element1){
                count1++;
            }
            else if(nums[i]==element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int counter1=0,counter2=0;
        for(int i=0;i<n;i++){//counting the number of times the element1 and element2 occurs in the array
            if(nums[i]==element1){
                counter1++;
            }
            else if(nums[i]==element2){
                counter2++;
            }
        }
        if(counter1>needForMajority){//adding the elements to the result if they are majority elements
            res.add(element1);
        }
        if(counter2>needForMajority && element1!=element2){
            res.add(element2);
        }
        return res;

    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 1, 1}; // Example input
        List<Integer> result = majorityElements_II_optimal_approach(nums);
        System.out.println(result); // Output: [2]
    }
}
