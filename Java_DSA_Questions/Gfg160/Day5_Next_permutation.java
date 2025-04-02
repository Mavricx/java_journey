package Java_DSA_Questions.Gfg160;
public class Day5_Next_permutation {
    public void reverse(int []arr, int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    void nextPermutation(int[] arr) {
        // code here
        int n=arr.length;
         int index=-1;
         for(int i=n-2;i>=0;i--){
             if(arr[i]<arr[i+1]){
                 index=i;//finding the index where the break point appears
                 break;
             }
         }
         if(index==-1){//if the whole array is already in the descending order then just return the next permutaion i.e. first permutation
             reverse(arr,0,n-1);
         }
         else{
         for(int i=n-1;i>=index;i--){//finding the least least larger number than the arr[index] and swaping it with arr[index]
             if(arr[i]>arr[index]){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                break;
             }
         }
         
         reverse(arr,index+1,n-1);//to get the next least larger number just reverse the sub array which is in descending order.
         }
        
    }
    public static void main(String[] args) {
        Day5_Next_permutation obj = new Day5_Next_permutation();
        int[] arr = {1, 2, 3, 6, 5, 4}; // Example input
        obj.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " "); // Output: 1 2 4 3 5 6
        }
        System.out.println(); // For better readability in output
    }
}
