package Java_Core_Concepts.Greedy_Algorithm;

import java.util.*;

public class Indian_Coins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 1234; // Example amount to make

        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(coins, Comparator.reverseOrder()); // Sort coins in descending order
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                while (amount >= coins[i]) {
                    amount -= coins[i];
                    ans.add(coins[i]);
                    count++;
                }
            }
        }
        System.out.println("Minimum number of coins: " + count);
        System.out.println("Coins used: " + ans);

    }
}
