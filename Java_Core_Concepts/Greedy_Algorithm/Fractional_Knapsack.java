//Fractional Knapsack
// Given the weights and values of N items, put these items in a knapsack of
// capacity W to get the maximum total value in the knapsack.
// value = [60, 100, 1201
// weight = [10, 20, 301
// w = 50
// ans 240
package Java_Core_Concepts.Greedy_Algorithm;

import java.util.*;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;

        // 1st find the value/weight ratio of all the items
        // sort the items based on value/weight ratio in he decreasing order

        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));// increasing order

        int capacity = w;
        int finalValue = 0;
        for (int i = ratio.length - 1; i >=0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                capacity -= weight[idx];
                finalValue += value[idx];
            } else {
                finalValue += capacity * ratio[i][1];
                capacity = 0;
            }

        }

        System.out.println(finalValue);
    }
}
