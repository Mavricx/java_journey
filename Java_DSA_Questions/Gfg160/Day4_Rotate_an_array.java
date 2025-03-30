package Java_DSA_Questions.Gfg160;

public class Day4_Rotate_an_array {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);//reverse the whole array
        reverse(nums,0,k-1);//reverse first k elements
        reverse(nums,k,n-1);//reverse the rest of the elements
        
    }
    private void reverse( int arr[], int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Day4_Rotate_an_array obj = new Day4_Rotate_an_array();
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; // Example input
        int k = 3; // Number of positions to rotate
        obj.rotate(arr, k);
        for (int i : arr) {
            System.out.print(i + " "); // Output: 5 6 7 1 2 3 4
        }
    }
}
