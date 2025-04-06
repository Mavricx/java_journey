package Java_DSA_Questions.Leetcode75;

public class Single_Number {
    public int singleNumber(int[] nums) {
        int sol=0;
        for (int i=0;i<nums.length;i++){
           sol=sol^nums[i]; //i.e: 2,4,2,4,5--->then 2^2 and 4^4 wil cancel out leaving 5 behind
        }   
        return sol;
       }
    
    public static void main(String[] args) {
        Single_Number obj=new Single_Number();
        int arr[]={2,4,2,4,5};
        System.out.println(obj.singleNumber(arr));
    }
}
