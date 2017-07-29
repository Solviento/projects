import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	public int name;
	public int x;
	public int y;
	public boolean known; // Initially false
	public double distance; // total distance from origin point
	public Vertex prev;
	public List<Edge> adjacentEdges;
	public Double shortest_cost; // Modded for cost calculations

	public Vertex(int name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		// by default java sets uninitialized boolean to false and double to 0
		// hence known == false and dist == 0.0
		adjacentEdges = new LinkedList<Edge>();
		prev = null;
	}

	@Override
	public int hashCode() {
		// we assume that each vertex has a unique name
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof Vertex)) {
			return false;
		}
		Vertex oVertex = (Vertex) o;

		return name == oVertex.name && x == oVertex.x && y == oVertex.y;
	}

	public void addEdge(Edge edge) {
		adjacentEdges.add(edge);
	}

	public String toString() {
		return name + " (" + x + ", " + y + ")";
	}

	@Override
	public int compareTo(Vertex v) { // Might be source of bugs, verify if working correctly. Meant to be used by priority queue ordering
		
		return this.shortest_cost.compareTo(v.shortest_cost);
	}

}