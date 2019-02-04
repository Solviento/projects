import java.io.PrintStream;
import java.util.Arrays;

/* Shows how a recursive binary search would work for an array of Rectangle objs */

public class p2{
	
	/* Signature method we call to implement recursive algorithm */
  	public static <AnyType extends Comparable<AnyType>> 
  	int binarySearch(AnyType[] a, AnyType b){
	    
	return binary(a, b, 0, a.length - 1);
  }
		    
	/* Will recursively search through an array */
	public static <AnyType extends Comparable<AnyType>> int binary(AnyType[] a, AnyType item, int low, int high){
	    /* Will cut array in half and match elements from both ends and middle */
		int mid = (low + high) / 2;
	    if (mid > high) {
	      return -1;
	    }
		if (mid < low) {
	      return -1;
		}
		/* If above is executed, then array is not presorted */
	    if (a[mid] == item) {
	      return 1; // Object found, return true
	    }
		else if (a[mid].compareTo(item) < 0) {
			return binary(a, item, mid + 1, high);
		}else{
			return binary(a, item, low, mid - 1);
	}
																	
	/* Tester main function for implementing a recursive binary search */
	public static final void main(String... paramVarArgs){
		Rectangle r1 = new Rectangle(22, 6);
		Rectangle r2 = new Rectangle(10, 5);
		Rectangle r3 = new Rectangle(4, 5);
		Rectangle r4 = new Rectangle(3, 4);
		Rectangle r5 = new Rectangle(2, 3);
		Rectangle r6 = new Rectangle(1, 1);
																												    
		Rectangle[] rects = { r1, r2, r3, r4 };
		
		Arrays.sort(rects); // Calling sort method from Arrays library
		
		int i = binarySearch(rects, r6);
		int j = binarySearch(rects, r1);
																											    
		System.out.println("Return value of searching for r6: " + i);
		System.out.println("Return value of searching for r1: " + j);
	}
}
