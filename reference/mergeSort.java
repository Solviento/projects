/* Merge sort (Weiss)
// For own reference
*/
private static 
<AnyType extends Comparable<? super AnyType>> 
void mergeSort( AnyType [ ] a, AnyType [ ] tmpArray, int left, int right ) {
	if( left < right ) {
		int center = ( left + right ) / 2; mergeSort(a, tmpArray, left, center ); mergeSort( a, tmpArray, center + 1, right);
		merge( a, tmpArray, left, center + 1, right );
	} 
} /** * Mergesort algorithm.
* @param a an array of Comparable items. */
public static <AnyType extends Comparable<? super AnyType>> void mergeSort( AnyType [ ] a ) {
AnyType [ ] tmpArray = (AnyType[]) new Comparable[ a.length ]; mergeSort( a, tmpArray, 0, a.length - 1 );
