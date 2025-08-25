package Java_Core_Concepts.Hashing;

import java.util.HashMap;

public class Subarray_sum_Equal_to_k {
    // return number of such subarray whose sum is equal to k
    // ex: arr={1,2,3},k=3
    // ans: 2 (sub arrays: {1,2}, {3})
    // approach
    // 1. Use a HashMap to store the cumulative sum up to each index.
    // 2. As you iterate through the array, calculate the cumulative sum.
    // 3. For each cumulative sum, check if (cumulativeSum - k) exists in the HashMap.
    // 4. If it exists, it means there is a sub array that sums to k, so add the count from the HashMap.
    // 5. Also, store the current cumulative sum in the HashMap.
    // sum(0,j)-sum(0,i-1)=sum(i,j)=k

    public static void main(String[] args) {
        int arr[]={10,2,-2,-20,10};
        int k=-10;
        HashMap<Integer, Integer> map=new HashMap<>();//<sum,count> 
        int sum=0;
        int count=0;
        map.put(0,1);//to handle the case when sum itself is equal to k
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum-k)){// Check if (cumulativeSum - k) exists
              count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println("Number of sub arrays with sum "+k+" is: "+count);
    }
} 
