//Jason Perez
//UNI: jp3476
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;

public class TopSort {

	public LinkedHashSet<String> vertexQueue = new LinkedHashSet<>();
	private CopyOnWriteArrayList<TopVert> vertexList = new CopyOnWriteArrayList<>();

	public TopSort() {
		// Implement topsort
	}

	//Adds vertex to linkedhashset
	public void addVertex(TopVert vertex) {
		vertexList.add(vertex);
	}

	//Returns vertices list
	public CopyOnWriteArrayList<TopVert> returnList() {

		return vertexList;

	}

	//Returns vertices queue
	public LinkedHashSet<String> returnQueue() {
		return vertexQueue;
	}

	//Returns indegree of vertex
	public int getIndegree(TopVert v) {

		return v.returnIndegree();
	}

	public void printList() {
		System.out.println(vertexQueue);
	}

	public void sort() {

		List<TopVert> verticesList = returnList(); //

		boolean sentinel = true;
		LinkedList<String> iterate = new LinkedList<>();

		while (sentinel) {

			if (verticesList.size() == 0) { // Excecuted once vertex list is
											// depleted
				sentinel = false;
				printList();
			}

			for (TopVert v : verticesList) { // Go through each and search for courseID
				if (v.returnIndegree() < 1) {

					vertexQueue.add(v.returnID());

					iterate.add(v.returnID());

					verticesList.remove(v);

				}
			}
			for (TopVert w : verticesList) { // Go through each and search for remaining courseIDs

				for (String s : iterate) {

					if (w.verifyPrereq(s)) {

						w.decreaseIndegree(); //

					}
				}
			}
		}
	}

	public static void main(String... args) throws IOException {

		FileInputStream fis = new FileInputStream(args[0]);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;

		TopSort sortMe = new TopSort();

		while ((line = br.readLine()) != null) { //File is being read

			StringTokenizer st = new StringTokenizer(line);

			if (st.countTokens() > 1) { // Vertex with adjacent vertices

				TopVert token = new TopVert(st.nextToken());

				while (st.hasMoreTokens()) {
					token.addNeighbor(st.nextToken());
				}
				sortMe.addVertex(token);

			}
			if (st.countTokens() == 1) { // Single vertex with no adjacent vertices
				TopVert token = new TopVert(st.nextToken());

				sortMe.addVertex(token);

			}
		}
		sortMe.sort();

	}
}
