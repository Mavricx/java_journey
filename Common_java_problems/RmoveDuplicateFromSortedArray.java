package Common_java_problems;
public class RmoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
       
        int counter = 1;
       
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i]+" ");
        // }
        // System.out.println(" ");
        return counter;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,0,1,1,2,3,3,3,4,5,5,6,6};
        System.out.println(removeDuplicates(nums));
    }
}
