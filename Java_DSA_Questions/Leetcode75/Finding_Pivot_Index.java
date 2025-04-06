package Java_DSA_Questions.Leetcode75;

public class Finding_Pivot_Index {
    public static int pivotIndex(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int totalLeft=0;
        for(int i=0;i<nums.length;i++){
            int totalRight=total-totalLeft-nums[i];
            if(totalLeft==totalRight){
                return i;
            }
             totalLeft+=nums[i];
        }
         return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
        }
}
