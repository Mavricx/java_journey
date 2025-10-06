package Java_Core_Concepts.Graphs;

import java.util.*;

public class Topological_Sort_BFS_Kahns_algo {
    // Kahn's Algorithm (BFS Approach)
    // 1. Calculate in-degrees of all vertices.
    // 2. Initialize a queue and enqueue all vertices with in-degree 0.
    // 3. While the queue is not empty:
    // a. Dequeue a vertex from the queue and add it to the topological order.
    // b. For each neighbor of the dequeued vertex, decrease its in-degree by
    // if in-degree becomes 0, enqueue it.
    // 4. If the topological order contains all vertices, return it; otherwise, a
    // cycle
    // exists in the graph.
    // Time complexity: O(V+E) where V is the number of vertices and E is the number
    // of edges.

    // FACT:: A DAG has at least one vertex with in-degree 0(u) and one vertex with
    // out-degree 0(v)
    // The path from u to v in a DAG is always unique and longest path(u->v) in DAG
    // can be found using topological sorting.

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 0));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 3));

    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");//topological order
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);

    }
}