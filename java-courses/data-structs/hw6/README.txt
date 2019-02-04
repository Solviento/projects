Jason Perez
UNI: jp3476


Programming: Compile using Eclipse. May also compile by using "javac" on
all files and then entering java for each to run.

1) Generated a random complete graph by using a linkedlist of all the
vertices in the generated map. Once all vertices were in a list,
I added them into their respective edges in a for loop. These
edges were then inserted back into the generated map. Each vertex
all has randomized x and y values as I used randInt() to generate them.
Their respective edge costs were also computed by the given
computeEuclideanDistance method. 

2) Implements nearest neighbor algorithm (greedy). It returns a list of 
edges. In my algorithm I try all vertices as starting vertices. It works by
picking a starting vertex and then looking through all edges of that vertex, 
pick the edge with the least cost -> I used a priority queue to implement 
this, least cost edge path will be chosen after all edges have been 
inserted and compared using their shortest_cost value 
(poll() was a good method for this). It continued doing this until all 
non-starting vertices are visited. Once all vertices have been visited, 
the path returned to the starting vertex. This path (list of edges) was then 
returned and evaluated.

3) This part was tricky as I implemented various algorithms to try to solve
for all permutations and did not get anywhere. When I finally found a viable
solution after attempting for hours, it was too late for me to debug my
code and give the final correct output. The parts of code that is commented
in the brute force method was my original attempts that failed. For the part
that is not commented, I decided to compute all permutations of the vertices.
Since each vertex had an ID of 0, 2, 3, 4 etc, I decided to combine these
and get all the combinations. Once I obtained the combinations I simply
constructed each vertex's edges into a list, which was then inserted in another
list. Since I did not have time to fully flesh this out, I was only able
to give an output that is not correct.