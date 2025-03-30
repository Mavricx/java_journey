package Java_DSA_Questions.Gfg160;

public class Day3_Reverse_an_array {
    public static void reverseArray(int arr[]) {
        // code here
        int len=arr.length;
        for(int i=0;i<len/2;i++){
            int temp=arr[i];
            arr[i]=arr[len-1-i];
            arr[len-1-i]=temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example input
        reverseArray(arr);
        for (int i : arr) {
            System.out.print(i + " "); // Output: 5 4 3 2 1
        }
    }
}
