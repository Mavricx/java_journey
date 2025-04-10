package Java_DSA_Questions.Gfg160;

public class Day13_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];//store current value in temp
                nums[i]=nums[temp-1];//in the current element store the arr[current value -1]
                nums[temp-1]=temp;// store the current value in the temp-1 place
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        Day13_First_Missing_Positive obj = new Day13_First_Missing_Positive();
        int[] nums = {3, 4, -1, 1};
        System.out.println(obj.firstMissingPositive(nums)); // Output: 2
    }
}
