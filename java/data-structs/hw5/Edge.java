//Jason Perez
//UNI: jp3476
public class Edge {

	public double distance;
	public Vertex source;
	public Vertex target;

	public Edge(Vertex vertex1, Vertex vertex2, double weight) {
		source = vertex1;
		target = vertex2;
		this.distance = weight;
	}

	public Edge(Vertex v1, Vertex v2) {
		source = v1;
		target = v2;
		// May need to set distance value
	}

	public String toString() {
		return source + " - " + target;
	}

	public double getDistance() {
		return distance;
	}
}