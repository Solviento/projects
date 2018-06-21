import java.util.LinkedList;
import java.util.HashMap;

//Jason Perez
//UNI: jp3476

public class TopVert {

	private String name;
	private HashMap<String, LinkedList<String>> courseID = new HashMap<>();
	// Keys// are// courseID,// values// are// pre// reqs
	public int currentIndegree = 0;
	public int initialIndegree = 0;

	public TopVert(String vertexName) {

		name = vertexName;
		courseID.put(vertexName, new LinkedList<String>());
	}

	public void addNeighbor(String vertNeighbor) {

		courseID.get(name).add(vertNeighbor);
		currentIndegree++;
		initialIndegree = currentIndegree;
	}

	public boolean verifyPrereq(String prereq) {

		return courseID.get(name).contains(prereq);
	}

	public String returnID() {
		return name;
	}

	public LinkedList<String> returnNeighbors() {
		if (courseID.get(name) != null) {
			return courseID.get(name);
		} else {
			return null;
		}
	}

	public int returnIndegree() {

		return currentIndegree;
	}

	public void decreaseIndegree() {

		currentIndegree--;
	}

	public String toString() {
		if (courseID.get(name).size() > 0) {

			String s = "";
			for (String word : courseID.get(name)) {
				s = s + " " + word;

			}
			return name + +currentIndegree + s;
		}

		else {
			return name;
		}
	}
}
