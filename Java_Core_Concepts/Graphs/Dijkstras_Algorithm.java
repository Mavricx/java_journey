package Java_Core_Concepts.Graphs;

import java.lang.reflect.Array;
import java.util.*;

public class Dijkstras_Algorithm {
    // Goal: find the shortest path from source to all other vertices
    // works only for positive weights
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {// node, path so far from src to n
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;// ascending order
        }
    }

    // approach
    // 1. Create a priority queue to store the nodes to be processed
    // 2. Initialize the distance of the source node to 0 and all other nodes to
    // infinity
    // 3. While the priority queue is not empty, extract the node with the smallest
    // distance
    // 4. For each neighbor of the extracted node, update its distance if a shorter
    // path is found
    public static int[] dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];// dist[i]=distance from src to i
        // initially all are infinite
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        dist[src] = 0;
        boolean vis[] = new boolean[graph.length];// to check if the node is processed or not
        // PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.path-y.path);
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // min heap to get the node with the smallest path value
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int dist[] = dijkstra(graph, 0);
        int src = 0;
        System.out.println("Shortest path from source " + src + " to all other vertices:");
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Distance to " + i + " is " + dist[i]);
        }
    }
}
