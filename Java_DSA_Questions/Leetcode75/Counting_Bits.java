package Java_DSA_Questions.Leetcode75;

public class Counting_Bits {
    public static int[] countBits(int n) {
        int res[] = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {// if the current element is one of these{1,2,4,8,16,32...}
                offset = i;
            }
            res[i] = 1 + res[i - offset];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int arr[] = countBits(n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
