package Java_Core_Concepts.Strings;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        char arr[] = { 'a', 'b', 'c' };
        String str = "hello there";
        String str2 = new String("my name is priyanshu");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String name = sc.next();// only takes single word as input
        System.out.println(name);
        // for multiple words
        sc.nextLine();// to clear the buffer. If we don't do this, the next line will not be executed
        String name2 = sc.nextLine();
        System.out.println(name2);

    }
}
