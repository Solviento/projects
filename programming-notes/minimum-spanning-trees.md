# minimum-spanning-trees
Prim's algorithm (greedy)


short version
Choose a starting node, choose the lowest costing edge. 
From already visited nodes, choose the lowest costing edge connected to EACH of those nodes. With each visited node, we will gain more edges to choose from (we must always choose lowest costing edge until ALL vertices have been visited once)


longer version
The idea is to maintain two sets of vertices (nodes). The first set contians the vertices already included in the MST and the second set contains vertices not yet included.
At every step it considers all edges that connect the two sets and picks the minimum cost edge. After picking the edge it moves the other endpoint of the edge (a vertice) to the set containing the MST. A spanning tree means all vertices must be connected. 


algorithm

```java
create a set MSTset that keeps track of vertices already included in MST
assign a key value to all vertices in the input graph, initialize all key values as INFINITE, assign key value as 0 for the first vertice so that it is picked first
while MSTset doesnt include all vertices
    pick a vertice u which is not in MSTset and has minimum ke value
    include u to MSTset
    update key value of adjacent vertices of u, to update the key values iterate through all adjacent vertices
    for every adjacent vertice v, if the weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v
```


Kruskal's algorithm


short version
Choose lowest cost edge, then continue to look for and find next lowest costing edges.
We pick specific edges so long as they DO NOT form a cycle between vertices. 
Continue choosing lowest costing edges until all vertices have been and there are NO cycles
**Disjoint sets may be used in its implementation. By connecting two edges to the same vertex we are essentially calling UNION on the two known edges into one set of known edges


longer version
To start, pick the lowest edge. We repeatedly check for the lowest costing edge and pick the one that does not form a cycle.
A minimum spanning tree has (V-1) edges where V is the number of vertices in the graph. 


algorithm

```java
sort all edges in non decreasing order of their cost
pick smallest edge, check if it forms a cycle with the spanning tree formed so far. if no cycle is formed, include this edge. Else, discard it
Repeat above step until there (V-1) edges left in the spanning tree
```


in order to detect a cycle we use a Union-Find algorithm


algorithm


























































