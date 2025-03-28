public class Product_of_array_except_self{

    public static int[] productExceptSelf(int[] nums) {
        int [] output=new int [nums.length];
        for(int i=0;i<nums.length;i++){//make every element in the new output array 1
            output[i]=1;
        }
        int left=1;
        for(int i=0;i<nums.length;i++){
            output[i]*=left;// Stores product of all elements to the left of i.
            left*=nums[i];//update the value for left for next element.
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            output[i]*=right;//Stores product for all element to the right of i.
            right*=nums[i];//update the value for previous element.
        }
        return output;//return the final output array.
    }
    public static void main(String[] args) {
       int nums[]={1,2,3,4,5};
       int output[]=productExceptSelf(nums);
            for(int i=0;i<output.length;i++){
                System.out.print(output[i]+" ");
            }
    }
}