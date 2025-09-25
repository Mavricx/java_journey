package Java_DSA_Questions.Other_Problems;

public class Divide_two_Integers {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend < 0) ^ (divisor < 0);

        long a =  Math.abs((long)dividend);
        long b =  Math.abs((long)divisor);
        int result = 0;

        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= temp * 2) {
                temp *= 2;
                multiple *= 2;
            }
            a = a - temp;
            result += multiple;
        }
        return sign ? -result : result;
    }
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
