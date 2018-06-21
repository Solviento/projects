public class Edge implements Comparable<Edge> {

	public Double distance;
	public Vertex source;
	public Vertex target;

	public Edge(Vertex vertex1, Vertex vertex2, double weight) {
		source = vertex1;
		target = vertex2;
		this.distance = weight;
	}

	public String toString() {
		return source + " - " + target;
	}

	public int compareTo(Edge e) {
		return this.distance.compareTo(e.distance);
	}
}