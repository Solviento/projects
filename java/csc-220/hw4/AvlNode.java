public class AvlNode<AnyType> {

	AnyType element; 				// The data in the node
	AvlNode<AnyType> left; 			// Left child
	AvlNode<AnyType> right; 		// Right child
	int height; 					// Height

	// constructors
	AvlNode(AnyType theElement){
		this(theElement, null, null);
	}

	AvlNode(AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt)
	{
		element = theElement;
		left = lt;
		right = rt;
		height = 0;

	}
}
