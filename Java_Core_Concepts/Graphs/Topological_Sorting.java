package Java_Core_Concepts.Graphs;

import java.util.*;
public class Topological_Sorting {
 //Directed Acyclic Graph(DAG) is a directed graph with no cycles.
 //Topological sorting is only possible in DAG.
 //Topological sorting is a linear ordering of vertices such that for every directed edge u->v, vertex u comes before v in the ordering.
 //Helpful in scheduling tasks, resolving dependencies, etc.   
 

 //Modified DFS approach
    //1. Perform a DFS traversal of the graph.
    //2. On the recursive callback of the DFS, add the node to a stack.
    //3. Finally, pop all elements from the stack to get the topological order.
    //Time complexity: O(V+E) where V is the number of vertices and E is the number of edges.

    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
       for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
       }
       graph[5].add(new Edge(5,0));
       graph[5].add(new Edge(5,2));
       graph[4].add(new Edge(4,0));
       graph[4].add(new Edge(4,1));
       graph[3].add(new Edge(3,1));
       graph[2].add(new Edge(2,3));
    }


    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topologicalSortHelper(graph,i,vis,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+"  ");
        }
    }

    public static void topologicalSortHelper(ArrayList<Edge> graph[], int curr,boolean vis[], Stack<Integer> stack){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSortHelper(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
         
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph);
    }

}
