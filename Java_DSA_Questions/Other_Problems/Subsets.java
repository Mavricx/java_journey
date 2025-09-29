package Java_DSA_Questions.Other_Problems;
import java.util.*;
public class Subsets {
    public static List<List<Integer>> findSubsets(int nums[]){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        //call backtrack
        backtrack(nums,0,res,current);
        return res;
    }
    public static void backtrack(int nums[], int idx, List<List<Integer>> res,List<Integer> current){
        if(idx==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        //exclude the current element from the subset
        backtrack(nums,idx+1,res,current);
        //include the current element in the subset
        current.add(nums[idx]);
        backtrack(nums,idx+1,res,current);
        current.remove(current.size()-1);
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        List<List<Integer>> result=findSubsets(nums);
        for(List<Integer> subset:result){
            System.out.println(subset);
        }
    }
}
