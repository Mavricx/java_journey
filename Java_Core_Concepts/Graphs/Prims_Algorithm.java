package Java_Core_Concepts.Graphs;
import java.util.*;
public class Prims_Algorithm {
    // Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for
    // a weighted undirected graph.
    // This means it finds a subset of the edges that forms a tree that includes
    // every vertex
    // where the total weight of all the edges in the tree is minimized.
    // Time Complexity: O(E log V) where E is the number of edges and V is the
    // number of vertices.
    // Space Complexity: O(V) for storing the priority queue and the result.
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[0].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
 
    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Edge(0, 0, 0));// src, dest, wt
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.wt;
                for (int i = 0; i < graph[curr.dest].size(); i++) {// all edges of curr.dest
                    Edge e = graph[curr.dest].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Edge(e.src, e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Final Cost of MST: " + finalCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
