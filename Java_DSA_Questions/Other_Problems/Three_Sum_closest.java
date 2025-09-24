package Java_DSA_Questions.Other_Problems;
import java.util.*;
public class Three_Sum_closest {
    public static int threeSumClosest(int [] nums,int target){
        int n=nums.length;
        Arrays.sort(nums);
        int result=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if((Math.abs(sum-target)<Math.abs(result-target))){
                    result=sum;
                }
                if(sum==target){
                    return target;
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[]={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums, target));
    }
}
