import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> {

	private PriorityQueue<T> max_heap;
	private int k;
	private LinkedList<T> heap_elements;
	private Iterator<T> list;
	private List<T> k_largest;

	public KBestCounter(int k) {

		this.k = k;
		// Will reverse natural order of P. Queue (from minheap to max)
		max_heap = new PriorityQueue<>(Collections.reverseOrder());
		// Arraylike object to keep elements
		heap_elements = new LinkedList<>();
		// K sized array
		k_largest = new ArrayList<T>(k);
	}

	/*
	 * Homework Method Needs to process the next element in the set of data.
	 * This operation should run in the at-worst O(logk) time
	 */

	public void count(T x) {
		// Simply add to max heap and heap array objects
		max_heap.add(x);
		heap_elements.add(x);

	}

	public List<T> kbest() {
		// Reset list and then add using the first element in queue
		k_largest.clear();
		for (int i = 0; i < k; i++) {
			k_largest.add(max_heap.poll());
		}

		// Clear max heap, copy heap_elements into max heap
		// as poll() removes head elements from max heap
		max_heap.clear();
		list = heap_elements.iterator();
		// Reinsert by order
		while (list.hasNext()) {
			max_heap.add(list.next());
		}
		return k_largest;

	}
}
