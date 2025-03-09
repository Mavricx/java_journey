package Strings;

import java.util.Scanner;

public class ShortestPath {

    public static void shortestPath(String str) {
        int n = str.length();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'N'|| str.charAt(i) == 'n') {
                y++;
            } else if (str.charAt(i) == 'S'|| str.charAt(i) == 's') {
                y--;
            } else if (str.charAt(i) == 'E'|| str.charAt(i) == 'e') {
                x++;
            } else if (str.charAt(i) == 'W'|| str.charAt(i) == 'w') {
                x--;
            } else {
                System.out.println("Invalid Input");
                return;
            }
        }
        int shortestPath = (int) (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
        System.out.println("Shortest Path: " + shortestPath);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to find the shortest path:");
        String str = sc.nextLine();
        shortestPath(str);
    }
}
