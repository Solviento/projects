//Jason Perez
//UNI: jp3476
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Dijkstra {

	// Keep a fast index to nodes in the map
	protected Map<String, Vertex> vertexNames;

	public List<Edge> weightedPath;

	/**
	 * Construct an empty Dijkstra with a map. The map's key is the name of a
	 * vertex and the map's value is the vertex object.
	 */
	public Dijkstra() {
		vertexNames = new HashMap<String, Vertex>();
	}

	/**
	 * Adds a vertex to the dijkstra. Throws IllegalArgumentException if two
	 * vertices with the same name are added.
	 * 
	 * @param v
	 *            (Vertex) vertex to be added to the dijkstra
	 */
	public void addVertex(Vertex v) {
		if (vertexNames.containsKey(v.name))
			throw new IllegalArgumentException(
					"Cannot create new vertex with existing name.");
		vertexNames.put(v.name, v);
	}

	/**
	 * Gets a collection of all the vertices in the dijkstra
	 * 
	 * @return (Collection<Vertex>) collection of all the vertices in the
	 *         dijkstra
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
	public Vertex getVertex(String name) {
		return vertexNames.get(name);
	}

	/**
	 * Adds a directed edge from vertex u to vertex v
	 * 
	 * @param nameU
	 *            (String) name of vertex u
	 * @param nameV
	 *            (String) name of vertex v
	 * @param cost
	 *            (double) cost of the edge between vertex u and v
	 */
	public void addEdge(String nameU, String nameV, Double cost) {
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
	 * @param nameU
	 *            (String) name of vertex u
	 * @param nameV
	 *            (String) name of vertex v
	 * @param cost
	 *            (double) cost of the edge between vertex u and v
	 */
	public void addUndirectedEdge(String nameU, String nameV, double cost) {
		addEdge(nameU, nameV, cost);
		addEdge(nameV, nameU, cost);
	}

	public void addEdge(String nameU, String nameV) {
		addEdge(nameU, nameV, 1.0);
	}

	// STUDENT CODE STARTS HERE

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
	public double computeEuclideanDistance(double x1, double y1, double x2, // Good
																			// to
																			// go
			double y2) {

		double xDiff = x1 - x2;
		double xSqr = Math.pow(xDiff, 2); // Find power of 2

		double yDiff = y1 - y2;
		double ySqr = Math.pow(yDiff, 2); // Find power of 2

		double outpt = Math.sqrt(xSqr + ySqr); // Euclid distance formula

		return outpt;
	}

	/**
	 * Calculates the euclidean distance for all edges in the map using the
	 * computeEuclideanCost method.
	 */
	public void computeAllEuclideanDistances() { // Good to go

		Iterator<Vertex> allVertices = getVertices().iterator(); // Extract list
																	// of
																	// vertices

		while (allVertices.hasNext()) { // Iterate through vertex list

			Vertex v = allVertices.next(); // Instantiate
			List<Edge> edges = v.getEdges(); // Extract and instantiate edges
			Iterator<Edge> all_edges = edges.iterator(); // Iterate through
															// edges

			while (all_edges.hasNext()) {
				Edge e = (Edge) all_edges.next(); // Extract individual edge
				Vertex v1 = e.source; // Extract edge source vertex
				Vertex v2 = e.target; // Extract edge target vertex

				double dist = computeEuclideanDistance(v1.x, v1.y, v2.x, v2.y);
				e.distance = dist; // Compute and ovveride distance with Euclid
									// dist
			}
		}

	}

	/**
	 * Dijkstra's Algorithm.
	 * 
	 * @param s
	 *            (String) starting city name
	 */
	public void doDijkstra(String s) {

		// Dijkstra's algorithm

		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

		Vertex source = vertexNames.get(s);
		source.known = true;
		source.distance = 0.0;
		source.shortest_cost = 0.0;

		Vertex x;
		Vertex y;

		Iterator<Edge> adj;

		queue.add(source);

		while (queue.size() > 0) {

			x = queue.poll();
			x.known = true;

			adj = x.getEdges().iterator();

			while (adj.hasNext()) {
				Edge edge = adj.next();
				y = edge.target;
				if (!y.known) { // If target vertex is false
					if (x.shortest_cost + edge.distance < y.shortest_cost) {
						y.shortest_cost = x.shortest_cost + edge.distance; // Good
						y.prev = x; // Previous known vertex of y is now x
					}

					queue.add(y); // Greedy algorithm part here
				}
			}
			// Once while is finally completed, shortest path should be known
		}
	}

	/**
	 * Returns a list of edges for a path from city s to city t. This will be
	 * the shortest path from s to t as prescribed by Dijkstra's algorithm
	 * 
	 * @param s
	 *            (String) starting city name
	 * @param t
	 *            (String) ending city name
	 * @return (List<Edge>) list of edges from s to t
	 */
	public List<Edge> getDijkstraPath(String s, String t) {

		// TEST: s = boston t = atlanta

		doDijkstra(s); // Shortest path now known for s
		// Vertex source = vertexNames.get(s);
		Vertex target = vertexNames.get(t);

		LinkedList<Vertex> path = new LinkedList<>(); // Dijsktra path

		boolean complete = false;

		while (!complete) {
			path.addFirst(target);

			if (target.name.equals(s)) {

				complete = true;
			}

			target = target.prev;
		}

		// System.out.println(path);
		// Boston - New York - Washington - Raleigh - Atlanta
		// Instantiate the edges between each city, insert that into public
		// instance var. return the list

		weightedPath = new LinkedList<Edge>();

		//System.out.println(path.size());

		for (int i = 0; i < path.size(); i++) {

			Vertex prime = path.get(i);

			if ((i + 1 < path.size())) {
				Vertex sec = path.get(i + 1);
				Edge e = new Edge(prime, sec);
				weightedPath.add(e);
			}

		}

		return weightedPath;

	}

	// STUDENT CODE ENDS HERE

	/**
	 * Prints out the adjacency list of the dijkstra for debugging
	 */
	public void printAdjacencyList() {
		for (String u : vertexNames.keySet()) {
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

	/**
	 * A main method that illustrates how the GUI uses Dijkstra.java to read a
	 * map and represent it as a graph. You can modify this method to test your
	 * code on the command line.
	 */
	public static void main(String[] argv) throws IOException {
		String vertexFile = "cityxy.txt";
		String edgeFile = "citypairs.txt";

		Dijkstra dijkstra = new Dijkstra();
		String line;

		// Read in the vertices
		BufferedReader vertexFileBr = new BufferedReader(
				new FileReader(vertexFile));
		while ((line = vertexFileBr.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length != 3) {
				vertexFileBr.close();
				throw new IOException("Invalid line in vertex file " + line);
			}
			String cityname = parts[0];
			int x = Integer.valueOf(parts[1]);
			int y = Integer.valueOf(parts[2]);
			Vertex vertex = new Vertex(cityname, x, y);
			dijkstra.addVertex(vertex);
		}
		vertexFileBr.close();

		BufferedReader edgeFileBr = new BufferedReader(
				new FileReader(edgeFile));
		while ((line = edgeFileBr.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length != 3) {
				edgeFileBr.close();
				throw new IOException("Invalid line in edge file " + line);
			}
			dijkstra.addUndirectedEdge(parts[0], parts[1],
					Double.parseDouble(parts[2]));
		}
		edgeFileBr.close();

		// Compute distances.
		// This is what happens when you click on the "Compute All Euclidean
		// Distances" button.
		dijkstra.computeAllEuclideanDistances();

		// print out an adjacency list representation of the graph
		// dijkstra.printAdjacencyList();

		// This is what happens when you click on the "Draw Dijkstra's Path"
		// button.

		// In the GUI, these are set through the drop-down menus.

		String startCity = "Boston";
		String endCity = "Atlanta";

		// Get weighted shortest path between start and end city.

		dijkstra.doDijkstra("Boston");

		List<Edge> path = dijkstra.getDijkstraPath(startCity, endCity);

		System.out.print("Shortest path between " + startCity + " and "
				+ endCity + ": ");
		System.out.println(path);

		/*
		 * LinkedList<String> test = new LinkedList<>(); test.add("My");
		 * test.add("Name"); test.add("Is"); Iterator<String> testMe =
		 * test.iterator(); while(testMe.hasNext()){
		 * System.out.println(testMe.next()); if(testMe.hasNext()){
		 * System.out.println(testMe.next());
		 * 
		 * } if(!testMe.hasNext()){ System.out.println("ow"); } }
		 */

	}

}
