import java.util.Scanner;

public class statsTester{

	public static void main(String... args){

		Scanner keyb = new Scanner(System.in);
		System.out.println("How many elements will you enter to evaluate?: ");

		int num = keyb.nextInt();
		double[] arr = new double[num];		// Create a #num large array

		System.out.println("Enter elements (doubles only): ");
		for (int i = 0; i < num; i++){
			double val = keyb.nextDouble();
			arr[i] = val;
		}
		System.out.println("Min of elements entered: "+
		stats.min(arr) + "\nMax of array: " +
		stats.max(arr) + "\nMean of array: " +
		stats.mean(arr) + "\nMedian of array: " +
		stats.median(arr) + "\nStd dev of array: " +
		stats.stdDev(arr) + "\nMode of array: " +
		stats.mode(arr));
	}
}
