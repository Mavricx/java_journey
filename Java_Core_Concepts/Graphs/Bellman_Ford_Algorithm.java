package Java_Core_Concepts.Graphs;

import java.util.ArrayList;

public class Bellman_Ford_Algorithm {
    // Goal: find the shortest path from source to all other vertices
    // works for negative weights also unlike Dijkstra's algorithm
    // but doesn't work for negative weight cycles
    // time complexity: O(VE) , V=vertices, E=edges
    // why v-1 times? because the longest path can have atmost v-1 edges
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

    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V - 1; i++) {// v-1 times
            for (int j = 0; j < graph.size(); j++) {// edges
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;// vertices
        int E = 8;// edges
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        bellmanFord(edges, 0, V);
    }
}
