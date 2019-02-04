// Implementation of Prim's algorithm
/*
 * Implement prim's algorithm. Use the pseudocode in the book.
Generate hundred random inputs of size 10 for your code. Do the same thing for size 20, 30, ... .
Run your prim algorithm on each set and count the average number of steps for each set and plot them. 
Try to do the same thing but this time calculate the average running time.
Note: You only need knowledge of your data structures course. DUE JUNE 18TH
 */
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by nooreddin on 6/13/17.
 */
public class PrimTestDrive
{
	public static void main(String[] args) {
        ArrayList<int[][]> matrices = readInput();

        for(int[][] matrix : matrices) {
        	long startTime = System.nanoTime();    
            prim(matrix);
            long estimatedTime = (System.nanoTime() - startTime)/1000;
        }
    }
    private static ArrayList<int[][]> readInput() {
        return null;
    }
    /**
     * This method accepts the adjacency matrix of the graph and prints out the output MST.
     * <p>
     *     Example of output is:
     *     (0,1), (1,2), (1,4), (2,5), (5,3)
     *     Where the numbers are indices of the vertices.
     * </p>
     * @param matrix an <code>n*n</code> adjacency matrix of input graph
     */
    private static void prim(int[][] matrix) {

    	graph g = new graph(matrix);
    	
    	int u = 0;
    	int v = 0;
    	int steps = 0;
    	int num = g.getNodes();	// num of nodes
    	int[][] paths = g.matrix();// copy of matrix w infinite costs
    	int[] knownSet = new int[num];	// reached nodes
    	int[] mst = new int[num];		// min spanning tree
    	
    	knownSet = setMatrix(knownSet);
    	
    	knownSet[0] = 1;				// start at first vertice
    	mst[0] = 0;
    	
    	// iterate through number of nodes in the graph
    	for (int n = 1; n < num; n++){
    		
    		// will find min path from reached node to neighbor node (unreached)
           	for (int i = 0; i < num; i++){
           		for (int j = 0; j < num; j++){
           			// expands set of neighboring nodes in the knownset
           			if ((knownSet[i] == 1) && (knownSet[j] == 0)){
           				if (paths[i][j] < paths[u][v]){
           					u = i;
           					v = j;
           					steps++;
           				}
           			}
           		steps++;
           		}
           	}
           	// append the edge to the min spanning tree
           	mst[v] = u;
       		knownSet[v] = 1;
       		u = 0;
       		v = 0;
    	} 
    	printmst(mst);
    	//System.out.println("\n" +steps);
    }
    private static int[] setMatrix(int[] m){
    	for (int i = 0; i < m.length; i++){
    		m[i] = 0;
    	}
    	return m;
    }
    private static void printmst(int[] m){
        for ( int j = 1; j < m.length; j++ ){
            System.out.print( "("+ m[j] + ", " + j + ") " );
        }
    }
    private static int[][] generateMatrix(int n){
    	int[][] matrix = new int[n][n];
    	for(int i =0; i<n; i++){
    		for (int j =0; j <n; j++){
    			Random rand = new Random();
    			int num = rand.nextInt(50) + 1;
    			matrix[i][j] = num;
    		}
    	}
    	return matrix;
    }
}