import java.util.Random;
import java.util.Scanner;

public class Sort {
	
	// mergesort function
	public static void mergeSort(int[] array, int[] t, int l, int h) {
		
        if (l < h) {
        	// algorithm for mergesort
            int mid = (int) Math.floor((l + h) / 2);
            mergeSort(array, t, l, mid);
            mergeSort(array, t, (mid + 1), h);
            merge(array, t, l, mid, h);
        }
    }
	// merge sub function for mergesort
	private static void merge(int[] array, int[] temp, int low, int high, int mid) {
        int i = low;
        int j = high + 1;
        
        for (int k = low; k <= mid; k++) {
            temp[k] = array[k];
        }
        // uses array substitution
        for (int k = low; k <= mid; k++) {
            if (i > high) {
                array[k] = temp[j];
                j++;
            }
            else if (j > mid) {
                array[k] = temp[i];
                i++;
            }
            else if (temp[j] < temp[i]) {
                array[k] = temp[j];
                j++;
            } 
            else {
                array[k] = temp[i];
                i++;
            }
        }
    }
	// insertion sort function
	public static void insertionSort(int[] array) {
        int k;
        int i;
        // algorithm for insertion sort
        for (int j = 1; j < array.length; j++) {
            k = array[j];
            i = j - 1;
            while ((i >= 0) && (array[i] > k)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = k;
        }
    }
	// insertion sort sub function
	public static void insertionSort(int[] array, int low, int high) {
        int k;
        int i;
        // iterate through until elements are sorted
        for (int j = low + 1; j <= high; j++) {
            k = array[j];
            i = j - 1;
            while ((i >= low) && (array[i] > k)) {
                array[i + 1] = array[i];
                // decrease i
                i--;
            }
            array[i + 1] = k;
        }
    }
	// combined merge insertion sort
	public static void mergeInsertionSort(int[] arr, int[] t, int l, int h, double size){
        
		// we find partion to do merge
		int partition = l + (int) Math.floor(arr.length * size);
		// for calculating partition for insertion
        if (partition > h) {
            insertionSort(arr, l, h);
            return;
        }
        int mid = (int) Math.floor((l + h) / 2);
        mergeInsertionSort(arr, t, l, mid, size);
        mergeInsertionSort(arr, t, (mid + 1), h, size);
        merge(arr, t, l, mid, h);
    }
	public static void main(String[] args) {
		
		System.out.println("Please enter a number to create a random unsorted list of length n: ");
		Scanner keyb = new Scanner(System.in);
		
		int n = keyb.nextInt();
		int[] unsort = randomArrayGenerator(n);
        long timerStart, timerEnd;

		
		Sort s = new Sort();

        timerStart = System.nanoTime();
        s.insertionSort(unsort);
        timerEnd = System.nanoTime();
        System.out.println("runtime Insertionsort:  " + (timerEnd-timerStart));
        for (int i = 0; i < unsort.length; i++) {
            System.out.print(" " + unsort[i] + "");
        }
        System.out.println();
        
        int[] uns = randomArrayGenerator(n);
        int[] t = new int[uns.length];
        //t = unsort;

        timerStart = System.nanoTime();
        s.mergeSort(uns, t,0 ,uns.length-1);
        timerEnd = System.nanoTime();
        System.out.println("runtime mergeSort:  " + (timerEnd-timerStart));
        for (int i = 0; i < uns.length; i++) {
            System.out.print(" " + uns[i] + "");
        }
        
        int[] unsor = randomArrayGenerator(n);

        timerStart = System.nanoTime();
        mergeInsertionSort(unsor,t,0,unsor.length-1,1);
        timerEnd = System.nanoTime();
        System.out.println();
        System.out.println("runtime MergeInsertionSort:  " + (timerEnd-timerStart));
        for (int i = 0; i < unsor.length; i++) {
            System.out.print(" " + unsor[i] + "");
        }
    }
	public static int[] randomArrayGenerator(int n){
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++){
			Random rand = new Random();
			int num = rand.nextInt(10) + 1;
			a[i] = num;
		}
		return a;
	}

}
