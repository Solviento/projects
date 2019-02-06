import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Strassen algorithm for matrix multiplication 

public class Strassen {

	/* Square Matrix Multiplication */
	public static  int[][] matrixMult(int[][] A, int[][] B){
		int n = A.length;
		int[][] C = new int[n][n];
		// Standard convention process to cross mutliply two matrices
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				C[i][j] = 0;
				for (int k = 0; k < n; k++){
					// Multiply and add as per standard convention
					C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
				}
			}
		}
		
		return C;
	}
	/* Strassen Matrix Multiplication */
	public static int[][] Strassen(int[][] A, int[][] B){
		
		int n = A.length;
		int[][] C = new int[n][n]; 	// square matrices only
		/* base case */
		if (n<=1){
			C = matrixMult(A, B);
			return C; 
		}
		
		/* Strassen matrices */
		
		// A submatrices
		int[][] a11 = new int[n/2][n/2];
		int[][] a12 = new int[n/2][n/2];
		int[][] a21 = new int[n/2][n/2];
		int[][] a22 = new int[n/2][n/2];
		int[][] a00 = new int[n/2][n/2];	// temp matrix stores results
		// B submatrices
		int[][] b11 = new int[n/2][n/2];
		int[][] b12 = new int[n/2][n/2];
		int[][] b21 = new int[n/2][n/2];
		int[][] b22 = new int[n/2][n/2];
		int[][] b00 = new int[n/2][n/2];	// temp matrix stores results
		
		/* Strassen Splitting */
		for(int i = 0; i < n/2; i++){
			for(int j = 0; j < n/2; j++){
				// A splitting
				a22[i][j] = A[i+(n/2)][j+(n/2)];// lower right corner
				a21[i][j] = A[i+(n/2)][j];		// lower left corner
				a12[i][j] = A[i][j+(n/2)];		// upper right corner
				a11[i][j] = A[i][j];			// upper left corner
				// B splitting
				b22[i][j] = B[i+(n/2)][j+(n/2)];	// lower right corner
				b21[i][j] = B[i+(n/2)][j];		// lower left corner
				b12[i][j] = B[i][j+(n/2)];		// upper right corner
				b11[i][j] = B[i][j];			// upper left corner
			}
		}
		/* Strassen calculations (recursion) */
		
		// P1 = (a11+a22)*(b11+b22)
		int[][] P1 = Strassen(addMatrix(a11, a22), addMatrix(b11, b22));
		// P2 = (a21+a22)*(b11)
		int[][] P2 = Strassen(addMatrix(a21, a22), b11);
		// P3 = (a11)*(b12-b22)
		int[][] P3 = Strassen(a11, subtractMatrix(b12, b22));
		// P4 = (a22)*(b21-b11)
		int[][] P4 = Strassen(a22, subtractMatrix(b21, b11));
		// P5 = (a11+a12)*(b22)
		int[][] P5 = Strassen(addMatrix(a11, a12), b22);
		// P6 = (a21-a11)*(b11+b12)
		int[][] P6 = Strassen(subtractMatrix(a21, a11), addMatrix(b11, b12));
		// P7 = (a12-a22)*(b21+b22)
		int[][] P7 = Strassen(subtractMatrix(a12, a22), addMatrix(b21, b22));
		
		/* C matrix calculations */

		// C11 = P1+P4+P7-P5
		a00 = addMatrix(P1,P4);
		b00 = addMatrix(a00, P7);
		int[][] C11 = subtractMatrix(b00, P5);
		// C12 = P3+P5
		int[][] C12 = addMatrix(P3, P5);
		// C21 = P2+P4
		int[][] C21 = addMatrix(P2, P4);
		// C22 = P1+P3+P6-P2
		a00 = addMatrix(P1, P3);
		b00 = addMatrix(a00, P6);
		int[][] C22 = subtractMatrix(b00, P3);
		
		/* C matrix assignment */
		//C = assignMatrix(n, C11, C12, C21, C22);
		for(int i = 0; i < n/2; i++){
			for(int j = 0; j < n/2; j++){
				C[i][j] = C11[i][j];
				C[i][j+n/2] = C12[i][j];
				C[i+n/2][j] =	C21[i][j];
				C[i+n/2][j+n/2] =	C22[i][j];
			}
		}
		
		return C;
	}
	/* Simple matrix assignment */
	public static int[][] assignMatrix(int n, int[][] c11, int[][] c12, int[][] c21, int[][]c22){
		int[][] C = new int[n][n];
		int i,j;
		for(i = 0; i < n/2; i++){
			for(j = 0; j < n/2; j++){
				C[i][j] 		= c11[i][j];
				C[i][j+n/2] 	= c12[i][j];
				C[i+n/2][j]		= c21[i][j];
				C[i+n/2][j+n/2] = c22[i][j];
			}
		}
		return C;
	}
	/* Matrix Splitter */
	public void splitter(int[][] A, int[][] B, int x, int y){
		
	}
	/* Matrix Generator */
	private int[][] generateMatrix(int n){
    	int[][] matrix = new int[n][n];
    	for(int i =0; i<n; i++){
    		for (int j =0; j <n; j++){
    			Random rand = new Random();
    			int num = rand.nextInt(5) + 0;
    			matrix[i][j] = num;
    		}
    	}
    	return matrix;
    }
	/* Matrix Addition */
	public static int[][] addMatrix(int[][] A, int[][] B){
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;	
	}

	/* Matrix subtraction */
	public static int[][] subtractMatrix(int[][] A, int[][] B){
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}
	/* Test method */
	public static void main(String[] args){
		Strassen s = new Strassen();
		//int[][] mat1 = s.generateMatrix(4);
		System.out.println("Please enter a number to calculate nxn matrix multiplication: ");
		Scanner keyb = new Scanner(System.in);
		int n = keyb.nextInt();
		
		ArrayList<Long> timer = new ArrayList<Long>();
		
		for (int i = 0; i < 100; i++){
			long start = System.nanoTime();
			int[][] m1 = s.generateMatrix(n);
			int[][] m2 = s.generateMatrix(n);
			@SuppressWarnings("static-access")
			int[][] c  = s.Strassen(m1, m2);
			long end = System.nanoTime() - start;
			timer.add(end);
		}
		long averageTime = runningTime(timer);
		System.out.println("\nAverage running time (nanosec): " + averageTime + "\n");
	}
	// returns average running time
    private static long runningTime(ArrayList<Long> trials){
        long total = 0;
        for(int i = 0; i < trials.size(); i++){
            total += trials.get(i);
        }
        total = total / trials.size();
        return total;
    }
	/* Print Matrix */
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}	
}
