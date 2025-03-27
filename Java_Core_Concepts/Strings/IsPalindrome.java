package Java_Core_Concepts.Strings;

import java.util.Scanner;

public class IsPalindrome {
    public static boolean isStringPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                System.out.println("Not a palindrome");
                return false;
            }
        }
        System.out.println("Palindrome");
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String str = sc.nextLine();
        isStringPalindrome(str);
    }
}
