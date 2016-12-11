/*	Jason P.
	Problem 1
	
	Prompt:
	Define a rectangle class that provides a getLength method and a getWidth
	method. Rectangle should also implement the the Comparable class; it should
	compare by perimeter. Create another class called Problem1 that has the
	findMax routine (included below) and add a main method that creates an array
	of Rectangle objects and finds the largest Rectangle on the bases of its
	perimeter.
*/

/* Remember to declare class as the filename */

public class p1{
	
	/* findMax - Will locate largest generic objects (hence the use of Any, it
	could be AnyType, generic, GEN, but Any is simple to use) */

	public static <Any extends Comparable<Any>> Any findMax(Any[] arr){
	/* Since we are	using the compareTo function we must use an 'extends' on 
	Comparable to override it. Comparable is included in the Java library*/

		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++){
		/* Starts at 1 since arr[0] is alredy the largest in the array by default */
			
			/*Note compareTo requires two comparable generic objects */
			if (arr[i].compareTo(arr[maxIndex]) > 0)
				maxIndex = i;
			
			return arr[maxIndex];
		}
	}
	
	public static final void main(String... args){

		/* Creates three rectangle objects */
		Rectangle rect1 = new Rectangle(22, 4);
		Rectangle rect2 = new Rectangle(10, 4);
		Rectangle rect3 = new Rectangle(23, 5);

		/* Creating a rectangle array is just like any other type array */
		Rectangle[] rects = {rect1, rect2, rect3};

		System.out.println(findMax(rects));
	}
}
