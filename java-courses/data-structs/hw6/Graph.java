import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Graph {

	// Keep a fast index to nodes in the map
	private Map<Integer, Vertex> vertexNames;
	private Random raNum = new Random();
	public static List<String> inputList = new ArrayList<String>();
	public static List<Integer> convertedList = new ArrayList<>();

	// Returns random number from 0-100
	public int getRandInt() {
		return raNum.nextInt(100);
	}

	/**
	 * Construct an empty Graph with a map. The map's key is the name of a
	 * vertex and the map's value is the vertex object.
	 */
	public Graph() {
		vertexNames = new HashMap<>();
	}

	/**
	 * Adds a vertex to the graph. Throws IllegalArgumentException if two
	 * vertices with the same name are added.
	 * 
	 * @param v
	 *            (Vertex) vertex to be added to the graph
	 */
	public void addVertex(Vertex v) {
		if (vertexNames.containsKey(v.name))
			throw new IllegalArgumentException(
					"Cannot create new vertex with existing name.");
		vertexNames.put(v.name, v);
	}

	/**
	 * Gets a collection of all the vertices in the graph
	 * 
	 * @return (Collection<Vertex>) collection of all the vertices in the graph
	 */
	public Collection<Vertex> getVertices() {
		return vertexNames.values();
	}

	/**
	 * Gets the vertex object with the given name
	 * 
	 * @param name
	 *            (String) name of the vertex object requested
	 * @return (Vertex) vertex object associated with the name
	 */
	public Vertex getVertex(int name) {
		return vertexNames.get(name);
	}

	/**
	 * Adds a directed edge from vertex u to vertex v
	 * 
	 * @param nameU
	 *            (int) name of vertex u
	 * @param nameV
	 *            (int) name of vertex v
	 * @param cost
	 *            (double) cost of the edge between vertex u and v
	 */
	public void addEdge(int nameU, int nameV, Double cost) {
		if (!vertexNames.containsKey(nameU))
			throw new IllegalArgumentException(
					nameU + " does not exist. Cannot create edge.");
		if (!vertexNames.containsKey(nameV))
			throw new IllegalArgumentException(
					nameV + " does not exist. Cannot create edge.");
		Vertex sourceVertex = vertexNames.get(nameU);
		Vertex targetVertex = vertexNames.get(nameV);
		Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
		sourceVertex.addEdge(newEdge);
	}

	/**
	 * Adds an undirected edge between vertex u and vertex v by adding a
	 * directed edge from u to v, then a directed edge from v to u
	 * 
	 * @param name
	 *            (String) name of vertex u
	 * @param name2
	 *            (String) name of vertex v
	 * @param cost
	 *            (double) cost of the edge between vertex u and v
	 */
	public void addUndirectedEdge(int name, int name2, double cost) {
		addEdge(name, name2, cost);
		addEdge(name2, name, cost);
	}

	/**
	 * Computes the euclidean distance between two points as described by their
	 * coordinates
	 * 
	 * @param ux
	 *            (double) x coordinate of point u
	 * @param uy
	 *            (double) y coordinate of point u
	 * @param vx
	 *            (double) x coordinate of point v
	 * @param vy
	 *            (double) y coordinate of point v
	 * @return (double) distance between the two points
	 */
	public double computeEuclideanDistance(double ux, double uy, double vx,
			double vy) {
		return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
	}

	/**
	 * Computes euclidean distance between two vertices as described by their
	 * coordinates
	 * 
	 * @param u
	 *            (Vertex) vertex u
	 * @param v
	 *            (Vertex) vertex v
	 * @return (double) distance between two vertices
	 */
	public double computeEuclideanDistance(Vertex u, Vertex v) {
		return computeEuclideanDistance(u.x, u.y, v.x, v.y);
	}

	/**
	 * Calculates the euclidean distance for all edges in the map using the
	 * computeEuclideanCost method.
	 */
	public void computeAllEuclideanDistances() {
		for (Vertex u : getVertices())
			for (Edge uv : u.adjacentEdges) {
				Vertex v = uv.target;
				uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
			}
	}

	// STUDENT CODE STARTS HERE

	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) 
	    	inputList.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public void generateRandomVertices(int n) {
		
		String samp = "";
		for(int i = 0; i < n; i++){
			samp = samp + Integer.toString(i);
		}
		
		permutation(samp);
		// Input list now has all permutations
		
		for(String s: inputList){
			convertedList.add(Integer.parseInt(s));
		}
		// Converted list now has all converted permutations
		
		vertexNames = new HashMap<>(); // reset the vertex hashmap

		LinkedList<Vertex> babyVertices = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Vertex V = new Vertex(i, getRandInt(), getRandInt());
			babyVertices.add(V); // List of vertices created
		}

		// Once the for loop below is completed
		// Each vertex (0->n) will have an incoming/outgoing edge to every other
		// vertex
		for (int i = 0; i < babyVertices.size(); i++) {

			Vertex primary = babyVertices.get(i);

			for (Vertex j : babyVertices) {

				if (!j.equals(primary)) {
					Vertex adjacent = j;
					Edge edg = new Edge(primary, adjacent,
							computeEuclideanDistance(primary, adjacent)); 
					primary.addEdge(edg);
				} // All edges created and inserted for primary vertex
			}
			vertexNames.put(i, primary);
		}
		computeAllEuclideanDistances(); // compute distances
	}

	public List<Edge> nearestNeighborTsp() {
		
		//Implements nearest neighbor algorithm
		// RETURN LIST OF EDGES!!
		// Must try all vertices as starting vertices
		// How nearest neighbor will work
		//
		// NN Algorithm:
		// Pick a starting vertex
		// Looking through all edges of that vertex, pick
		// the edge with the least cost -> May use priority queue to implement this, least cost
		// will be chosen after all edges have been inserted and compared using their
		// shortest_cost value (poll() is a good method for this)
		// Continue doing this until all non-starting vertices are visited
		// Once all vertices have been visited
		// Return to starting vertex, Hamilton circuit found and must be returned
		
		
		int n = vertexNames.size(); // Get numbers of vertices in map
		LinkedList<Vertex> vList = new LinkedList<>();
		
		PriorityQueue<Edge> EdgeQueue = new PriorityQueue<>();
		
		List<Edge> NNPATH = new LinkedList<>();
		
		for(int i = 0; i < vertexNames.size(); i++){
			vList.add(vertexNames.get(i));
		}
		
		Edge nnEdge;
		
		
		Vertex refVert = vList.get(0);
		Vertex vex = vList.get(0);
		vex.known = true;
		
		while(NNPATH.size() < n){
			
			Vertex start = vex;
			List<Edge> edgeList = start.adjacentEdges;
			
			EdgeQueue.clear(); // Clear priority queue before using it
			
			for(Edge e: edgeList){
				if(e.target.known == false){
					
					EdgeQueue.add(e);
				}
			}
			
			nnEdge = EdgeQueue.poll();
			
			Edge insertMe = new Edge(start, nnEdge.target, computeEuclideanDistance(start, nnEdge.target));
			
			NNPATH.add(insertMe);
			
			vex = nnEdge.target; // Target vex of the smallest cost edge
			vex.known = true;
			
			
			
			if(NNPATH.size() == (n - 1)){
				
				Edge insMe = new Edge(vex, refVert, computeEuclideanDistance(vex, refVert));
				NNPATH.add(insMe);
				
			}
			//System.out.println(NNPATH.size());
			
		}
		
		return NNPATH;
		
	}

	public List<Edge> bruteForceTsp() {
		
		// Brute force makes a list of all possible hamilton circuits
		// Hamilton circuit visits all vertices once
		// TOTAL NUMBER OF HAM CIRCUITS WILL BE (N-1)!
		// Gives cost of O(n!)
		// Will have to use recursion - Set base case, and stopping point
		
		// Will have to obtain a list of a list of edges, each edge list will have a total distance cost
		// Start from 0' vertex, get the adjacent vertices from that vertex
		// Since we are making a list of all poss. circuits, we compose a list 
		
		// We now have all permutations of nodes (0, 1, 2, 3.. etc)
		
		// Contained in list<Integer> convertedList
		// [0123, 0132, etc
		
		// Map<integer, vertex> = 0, vertex 0 (and all adj edges)..
		
		List<String> conList = inputList;
		List<List<Edge>> motherList = new LinkedList<>();
		
		for(int i = 0; i < conList.size(); i++){
			
			List<Vertex> vertMix = new LinkedList<>();
			
			for(int j = 0; j < conList.get(i).length(); j++){
				
				String x = conList.get(i);
				String let = Character.toString(x.charAt(j));
				int vertID = Integer.parseInt(let);
				
				Vertex addMe = vertexNames.get(vertID); // Returns vertex j
				vertMix.add(addMe);
			}
			
			
			Vertex REF = vertMix.get(0);
			int size = vertMix.size();
			
			List<Edge> addListME = new LinkedList<>();
			
			for(int p=0; p < vertMix.size()- 1; p++ ){ 
				
				Edge addEdge = new Edge(vertMix.get(p), vertMix.get(p+1), computeEuclideanDistance(vertMix.get(p),vertMix.get(p+1) ) );
				addListME.add(addEdge);
				
			}
			
			Vertex Fin = vertMix.get(size-1);
			Edge returnEdge = new Edge(Fin, REF,computeEuclideanDistance(Fin, REF) );
			addListME.add(returnEdge);
			
			motherList.add(addListME);
			addListME.clear();
			
		}
	
		return motherList.get(0); // Will have to extract shortest cost list<edge> from list<list<edge>>, probably prior. queue

		
		/**
		
		List<Edge> returnMe; // Can be linked, array, etc - Must be set to optimal (least cost) circuit adjacentEdges list
		
		List<List<Edge>> listList = new LinkedList<>(); // It worked ! Utilize this in obtaining all lists (a lot of them)
		
		LinkedList<Vertex> vList = new LinkedList<>(); // List of all vertices in graph
		
		for(int i = 0; i < vertexNames.size(); i++){
			vList.add(vertexNames.get(i));
		}
		
		int n = vertexNames.size(); // Total number of vertices in graph
		int nStoppingPoint = n-1;
		int nMinus = factorial((n-1)); // Final number of ham. circuits
		**/
		
		/**		
		while(listList.size() < nMinus){
			
			for(Vertex vert: vList){ // Tricky for loop, will iterate through every vertex in graph, must recursively get all circuits for that vertex
				
				// Choosing example: A B C D (our vertices)
				// First run of loop will have A as starting vertex
				// Obtain adjacent edges for this starting vertex (A)
				
				List<Edge> startVERT = vert.adjacentEdges;
				
				List<Vertex> targetVertices = new LinkedList<>(); // Don't forget List type cannot be instantiated
				
				for(Edge e: startVERT){
					targetVertices.add(e.target); // Seems to do the job
				}
				
				// We get, B C D as adj vertices. Size of this list will be 3
				// Okay, so now target Vertices is represented by:
				// B C D
				// We choose B as our target vertex
				
				for(int i=0; i < nStoppingPoint; i++){ // Will stop after n-1 loops (4 - 1 =3)
					
					Vertex vertPrime = targetVertices.get(i); // i = 0, will give us B vertex
					
					// Now we get the target vertex B
					// We obtain its adjacent vertices
					// A C D
					// Remove A as it has been visited
					
					List<Edge> primeEdges = vertPrime.adjacentEdges;
					List<Vertex> targetVerticesPrime = new LinkedList<>();
					
					for(Edge e: primeEdges){
						targetVerticesPrime.add(e.target);
					}
					
					// A C D vertices obtained
					
					targetVerticesPrime.remove(vertPrime); // A is removed
					
					// Adjacent vertices list is now
					// C D
					
					Vertex tarSec = targetVerticesPrime.get(0);
					// Get C as our target vertex
					
					
					
					
				}
												
				// Do not finish until all circuits are known and listed for each vertex!
			}	
			break;
		}
		
		**/
		
	}
	

	public int factorial(int number) { // Used to calculate (n-1)! stopping point
	      if (number <= 1)
	         return 1;
	      else
	         return number * factorial(number - 1);
	   }
	

	// STUDENT CODE ENDS HERE

	/**
	 * Prints out the adjacency list of the graph for debugging
	 */
	public void printAdjacencyList() {
		for (int u : vertexNames.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(u);
			sb.append(" -> [ ");
			for (Edge e : vertexNames.get(u).adjacentEdges) {
				sb.append(e.target.name);
				sb.append("(");
				sb.append(e.distance);
				sb.append(") ");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}

	public static void main(String... args) {
		Graph gph = new Graph();
		gph.generateRandomVertices(4);
		
		
	}

}
