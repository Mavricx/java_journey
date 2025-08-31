import java.util.*;

public class Cycle_detection_in_Directed_graph {
    // approach
    // 1. We will use DFS to detect a cycle in the directed graph.
    // 2. We will maintain a visited array to keep track of visited nodes.
    // 3. We will also maintain a recursion stack to keep track of the nodes in the
    // current path.
    // 4. If we encounter a node that is already in the recursion stack, we have
    // found a cycle.

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack))
                    ;
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (Edge e : graph[curr]) {
            if (stack[e.dest]) {
                return true;// cycle exits
            }
            if (!vis[e.dest]) {
                if (isCycleUtil(graph, e.dest, vis, stack)) {
                    return false;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {

        /*
         * graph goes like this
         * 0 -> 2
         * ^ ^ |
         * | \ v
         * 1 3
         */
        int V = 5; // Example number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCyclic(graph));
    }
}
