// taken from Weiss textbook
import java.util.Random;

public class AvlTree<AnyType extends Comparable<AnyType>> {
	
	private AvlNode<AnyType> root;

	public AvlTree()
	{
		root = null;
	}
	
	// insert element into avl tree
	public void AvlInsert(AnyType x)
	{
		root = AvlInsert(x, root);
	}
	
	// insert node into avl tree root	
	private AvlNode<AnyType> AvlInsert(AnyType x, AvlNode<AnyType> t)//, int line)
	{
		if (t == null)
			return (AvlNode<AnyType>) new AvlNode<AnyType>(x, null, null);//, line);

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0)
			t.left = AvlInsert(x, t.left);
		else if (compareResult > 0)
			t.right = AvlInsert(x, t.right);
		
		return balance(t);
	}
	
	// balance an avl tree by root	
	int ALLOWED_IMBALANCE = 1;
	
	private AvlNode<AnyType> balance(AvlNode<AnyType> t)
	{
		if (t == null)
			return t;

		if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
			if (height(t.left.left) >= height(t.left.right))
				t = leftRotate(t);
			else
				t = doubleLeft(t);
		else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
			if (height(t.right.right) >= height(t.right.left))
				t = rightRotate(t);
			else
				t = doubleRight(t);

		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}
	
	// return height of node
	private int height(AvlNode<AnyType> t) {
		return t == null ? -1 : t.height;
	}
	
	// rotate left child	
	private AvlNode<AnyType> leftRotate(AvlNode<AnyType> k2) 
	{
		AvlNode<AnyType> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}
	
	// rotate right child
	private AvlNode<AnyType> rightRotate(AvlNode<AnyType> k1) 
	{
		AvlNode<AnyType> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}
	
	// double rotation on left child
	private AvlNode<AnyType> doubleLeft(AvlNode<AnyType> k3) 
	{
		k3.left = rightRotate(k3.left);
		return leftRotate(k3);
	}
	
	// double rotation on right child
	private AvlNode<AnyType> doubleRight(AvlNode<AnyType> k1) 
	{
		k1.right = leftRotate(k1.right);
		return rightRotate(k1);
	}
	
	// check root if it is null
	public boolean isEmpty() {
		return root == null;
	}
	
	// print tree as inorder array
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }
	
    private void printTree( AvlNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.print( t.element + " " );
            printTree( t.right );
        }
    }
	
	public static void main(String... args)
	{
		AvlTree<Integer> tree = new AvlTree<>();
		
		for (int i = 0; i < 12; i++){
			Random rand = new Random();
			int n = rand.nextInt(40) + 1;
			
			tree.AvlInsert(n);
		}
		
		System.out.println("Random Avl Tree array using Inorder representation: ");
		tree.printTree();
	}

}
