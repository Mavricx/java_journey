import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    //go to immediate neighbor first
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

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    //approach 1 using queue
    //1st add the source to the queue
    //2nd remove the front element and mark it visited and print it
    //3rd add all its unvisited neighbor to the queue
    //4th repeat step 2 and 3 until queue is empty
    //Note: in bfs all the neighbor at the current level is visited first before going to the next level
    //bfs is used to find the shortest path in an unweighted graph
    public static void bfs(ArrayList<Edge> graph[]) {//time Complexity O(V+E)  **important** and O(V^2) if adjacency matrix is used.
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source=0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {// visit current
                System.out.print(curr + " ");
                vis[curr] = true; //setting up that node visited
                // adding all the neighbor to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
         * 
         *   1----3
         * /      | \
         * 0      | 5--6
         * \      | /
         *   2----4
         * 
         */

        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
