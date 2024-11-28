package Common_java_problems;
public class Solution1 {
    static int revNum(int n) {
        int rev = 0;
        int t = n;
        while (t != 0) {
            rev = (rev*10)+t%10;
            t = t / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(revNum(9));
    }
}
