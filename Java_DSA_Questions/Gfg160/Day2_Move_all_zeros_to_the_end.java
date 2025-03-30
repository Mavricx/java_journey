package Java_DSA_Questions.Gfg160;

public class Day2_Move_all_zeros_to_the_end {
    static void pushZerosToEnd(int[] arr) {
        // code here
        int slow=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];//making a swap and then incrementing the slow if we encounter an non-zero element
                arr[i]=arr[slow];
                arr[slow]=temp;
                slow++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12}; // Example input
        pushZerosToEnd(arr);
        for (int i : arr) {
            System.out.print(i + " "); // Output: 1 3 12 0 0
        }
    }
}
