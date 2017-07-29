// Graph data structure for adjacency matrix
import java.util.*;

public class graph{
	
	// prim's algorithm requires us to set unvisited nodes as infinite cost to visit
	private static Integer infinite = Integer.MAX_VALUE;
	private int NumberNodes;	// Number of nodes in the graph
	private int[][] matrixCopy;	// Modified copy of the input matrix w zeros replaced by infinite cost

	public graph(int[][] matrix){
		NumberNodes = matrix.length;					// length of matrix = # nodes in the graph
		matrixCopy = new int[NumberNodes][NumberNodes];	// allocate memory for matrix copy
		
		// why the double for loop? its the only way to traverse through entire adjacency matrix
		for(int i = 0; i < NumberNodes; i++){
			for(int j = 0; j < NumberNodes; j++){
				if (matrix[i][j] == 0){
					matrixCopy[i][j] = infinite;		
					// 0 = no path exists, so we change it infinity so as to not confuse prim's algorithm
				}
				else{
					matrixCopy[i][j] = matrix[i][j];	// transfer path costs
				}
			}
		}		
	}
	// accessor methods
	public int getNodes(){
		return NumberNodes;
	}
	public int[][] matrix(){
		return matrixCopy;
	}
}
