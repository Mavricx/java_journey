package Java_DSA_Questions.Other_Leetcode_Problems;

import java.util.*;

public class Minimum_Cost_to_Reach_Destination {
    public static int minCost(int[][] edges, int[] passingFees, int maxTime) {
        int n = passingFees.length;
        List<int[]>[] graph = new List[n];
        int minTime[] = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[] { edge[1], edge[2] });// adding bidirectional edges
            graph[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);// sort in the order of passingFee.
        pq.add(new int[] { 0, passingFees[0], 0 });// node ,fee, time

        while (!pq.isEmpty()) {
            int[] rem = pq.poll();
            int node = rem[0];
            int fee = rem[1];
            int time = rem[2];

            if (time >= minTime[node] || time > maxTime)
                continue;
            if (node == n - 1)
                return fee;// reached last node
            minTime[node] = time;

            for (int[] e : graph[node]) {// explore the neighborhood
                int e_node = e[0];// dest
                int e_time = e[1] + time;
                int e_fee = fee + passingFees[e_node];

                pq.offer(new int[] { e_node, e_fee, e_time });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1, 10 }, { 1, 2, 10 }, { 2, 5, 10 }, { 0, 3, 1 }, { 3, 4, 10 }, { 4, 5, 15 } };
        int passingFees[] = { 5, 1, 2, 20, 20, 3 };
        int maxTime = 30;
        System.out.println(minCost(edges, passingFees, maxTime));
    }

}
