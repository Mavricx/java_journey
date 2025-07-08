package Java_Core_Concepts.Stacks;

import java.util.Stack;

public class Next_Greater_Element_II {
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int nxtGreater[]=new int[n];

        for(int i=2*n;i>=0;i--){
            int num=nums[i%n];
            while(!st.isEmpty() && st.peek()<=num){//check if the current number is greater than top or else pop it
               st.pop();
            }
            if(i<n){//while i <n check and decide nextgreater
                nxtGreater[i]=st.isEmpty()?-1:st.peek();
            }
            st.push(nums[i%n]);//after moving push the element into the stack.
        }
        return nxtGreater;
    }
    public static void main(String[] args) {
        int[] nums={9,3,3,7,2,1,6,-1};
        int result[] =nextGreaterElements(nums);
        for(int a:result){
            System.out.print(a+" ");
        }
    }
}//time complexity O(4n) {
    

