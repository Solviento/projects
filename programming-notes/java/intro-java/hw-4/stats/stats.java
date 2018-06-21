import java.util.*;

public class stats{
	
	public static double min(double[] values){
		// Calculates the minimum using a for loop to iterate through all elements 
		double min = values[0];

		for (double element: values){
			if (min > element){
				min = element;
			}
		}
		return min;
	}
	public static double max(double[] values){
		// Calculates max of a double array
		double max = values[0];
	
		for (double element: values){
			if(max < element){
				max = element;
			}
		}
		return max;
	}
	public static double mean(double[] values){
		// Calculates mean of a double array
		double sum = 0;
		
		for (double element: values){
			sum += element;
		}
		return (sum/values.length);
	}
	public static double meanArrList(ArrayList<Double> values){
		// Calculate mean of a double ArrayList
		double total = 0;

		for (int i = 0; i < values.size() - 1; i++){
			total += values.get(i);
		}
		return total/values.size();
	}
	public static double median(double[] values){
		// Sorts array, choose median element (if even length, return mean of
		// the two middle values
	
		Arrays.sort(values);
		double median = 0;
		double total = values.length;
		int low = 0;
		int high = values.length;
		double middle = (low + high)/2.0;

		if ((total % 2) == 0){
			// Even array cases only
			double first = middle;
			double second = middle+1;
			double[] tmpArr = {first, second};
			median = mean(tmpArr);
		}
		else{
			median = values[(int) middle];		// Cast as int (? Indexes must be int)
		}
		return median;
	}
	public static double stdDev(double[] values){
		// We use standard deviation formula for this method
		double mean = mean(values);
		
		ArrayList<Double> differences = new ArrayList<Double>();
		// Stores (arrayElement - mean)^2 values
		for (double element : values){
			double diff = element - mean;
			double sq = Math.pow(diff, 2);
			differences.add(sq);
		}
		double meanDiff = meanArrList(differences);
		double stdDev = Math.sqrt(meanDiff);

		return stdDev;
	}
	public static double mode(double[] values){
		// Determines mode of a double array, aka most frequent element
		Arrays.sort(values);
		
		Set<Double> set = new HashSet<Double>();
		for (double element : values){
			set.add(element);
		}
		// Set now has all unique values of the double array
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		// Store counters in the map for each unique element in the array
		for (double element : set){
			int tmpCount = 0;
			for (double i : values){
				if (i == element){
					continue;
				}
				else{
					tmpCount++;
				}
			}
			map.put(element, tmpCount);
		}
		int maxCount = 0;
		double maxDouble = 0;
		for (double key: map.keySet()){
			if (maxCount < map.get(key)){
				maxCount = map.get(key);
				maxDouble = key;
			}
			else{
				continue;
			}
		}
		return maxDouble;
	}		
}
