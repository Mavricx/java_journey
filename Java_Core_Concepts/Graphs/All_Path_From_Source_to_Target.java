package Java_Core_Concepts.Graphs;

import java.util.*;

public class All_Path_From_Source_to_Target {

    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }   
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[5].add(new Edge(5,0));
       graph[5].add(new Edge(5,2));
       graph[4].add(new Edge(4,0));
       graph[4].add(new Edge(4,1));
       graph[3].add(new Edge(3,1));
       graph[2].add(new Edge(2,3));
       graph[0].add(new Edge(0,3));
    }

     public static List<List<Integer>> allPathFromSourceToTarget(ArrayList<Edge> graph[],int source, int target){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(source);
        dfs(graph,source,target,path,result);
        return result;
     }

     public static void dfs(ArrayList<Edge> graph[], int source, int target, List<Integer> path, List<List<Integer>> result){
        if(source==target){
             result.add(path);
             return;
        }
        for(int i=0;i<graph[source].size();i++){
            Edge e=graph[source].get(i);
            dfs(graph,e.dest,target,new ArrayList<>(path){{add(e.dest);}},result);
        }
     }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        int source=5;
        int target=1;
        System.out.println(allPathFromSourceToTarget(graph, source, target));
    }

    }

