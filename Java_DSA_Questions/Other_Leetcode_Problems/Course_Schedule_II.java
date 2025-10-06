package Java_DSA_Questions.Other_Leetcode_Problems;

import java.util.*;

public class Course_Schedule_II {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int indeg[] = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int pair[] : prerequisites) {
            int dest = pair[0], src = pair[1];
            graph.get(src).add(dest);
            indeg[dest]++;// calculate indegree
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)
                q.offer(i);
        }
        int result[] = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            result[idx++] = curr;
            for (int neighbor : graph.get(curr)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        return idx == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int result[] = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}
