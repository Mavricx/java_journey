# Graph

- Network of nodes.

## Edges can be

1. Uni-directional
2. Un-directed
3. Bi-directional

### If we take edges into consideration

1. Weighted
2. Un-weighted

## Storing the Graph /Representation of Graph.

1. Adjacency List(List of Lists)[can be stored as ArrayList<ArrayList>,Array <ArrayList>, or hashmap<vertex, value>]
   Optimal Approach
   Array of ArrayList <Edges> --> 1.source 2.destination 3.weight of edge
2. Adjacency Matrix
3. Edge List(consist of pairs, each pair/edge consist of two source of destination node of that edge)
4. 2d Matrix

## Application of Graphs

1. Maps (Shorted Path)
2. Social Networks (Describe the connection between the profiles/person)
3. Delivery Network (shortest cyclic root)
4. Physics and Chemistry(To study molecular structure)
5. For routing algorithm
6. Machine learning (Computation graphs)
7. Dependency Graph
8. Computer Vision(Image segmentation)
9. For Database( Nebula, neo4g)
10. For research Purposes

## Cycle Detection in Graphs

### In case of undirected Graphs

      - we can use
      1. BFS
      2. DFS
      3. DSU(Disjoint set union)

### In case of directed Graphs

      - we can use
      1. BFS
      2. DFS
      #. Topological sort(Kahn's Algorithm)
 
-Generally DFS is used for easy implementation and low memory consumption.
 ### Here is the approach on cycle detection.
 - We are going to use DFS(recursive) for previous reasons.
 - While traversing the graph here comes three cases.
   1. case-I: The next node is unvisited and we call recursive detectCycle for cycle detection( return cycleDetect(next node))
   2. case-II: If the next node is visited and it is not our current parent then return true..as we found new path to the node where we visited earlier forming a cycle in the process.
   3. case-III : if the next node is our parent and is visited then we continue without any operation as this neighbor we visited earlier and don't need any operation for it.


 # Bipartite Graph
- A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge
(u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u
belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices of
same set.

# Minimum Spanning Tree(MST)
A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
 ## Conditions to be MST
  1. No Cycles should be present
  2. All vertices should be Connected.
  3. Minimum possible total edge weight.