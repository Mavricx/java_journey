package Java_DSA_Questions.Other_Leetcode_Problems;

public class Jump_Game {
    public static boolean canJump(int [] arr){
        int maxReach=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(i>maxReach) return false;
            maxReach=Math.max(i+arr[i],maxReach);
            if(maxReach>=n-1) return true;
        }
        return maxReach>=n-1;
    }
    public static void main(String[] args) {
        int [] arr={2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}
