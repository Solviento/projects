/* Generics */

public class problem1{

	public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] arr){
		//maxIndex indicates the largest generic object in the array
		int maxIndex = 0;

		for (int i = 1; i < arr.length; i++){

			//compareTo - custom function for distinguishing differences in generic properties
			if (arr[i].compareTo(arr[maxIndex]) > 0){
				maxIndex = i;
		}

		return arr[max[Index]];
	}

	public static void main(String... args){

		Rectangle rock1 = new Rectangle(22, 4);
		Rectangle rock2 = new Rectangle(10, 3);
		Rectangle rock3 = new Rectangle(23, 5);

		Rectangle[] rocks = {rock1, rock2, rock3};

		System.out.println(findMax(rocks));
	}
}
