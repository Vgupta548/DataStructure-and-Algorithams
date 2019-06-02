package DataStructure.matrix;

/**
 * For M*N matrix
 * @author vipingupta
 *
 */
public class Rotate90 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

		System.out.println("Original Matrix :");
		printMatrix(matrix);

		int[][] rotatedMatrix = rotateAntiClockWiseUsingExtraSpace(matrix);
		System.out.println("Clock wise Rotated Matrix :");
		printMatrix(rotatedMatrix);
		
		rotatedMatrix = rotateClockWiseUsingExtraSpace(matrix);
		System.out.println("Anti Clocke wise Rotated Matrix :");
		printMatrix(matrix);

	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	
	// Function to anticlockwise rotate 
    // matrix by 90 degree 
    static void rotate90(int arr[][]) 
    { 
        transpose(arr); 
        System.out.println("  transpose done");
        reverseColumns(arr); 
    } 
	
	// After transpose we swap elements of 
    // column one by one for finding left 
    // rotation of matrix by 90 degree 
    static void reverseColumns(int arr[][]) 
    { 
        for (int i = 0; i < arr[0].length; i++) 
            for (int j = 0, k = arr[0].length - 1; 
                 j < k; j++, k--) { 
                int temp = arr[j][i]; 
                arr[j][i] = arr[k][i]; 
                arr[k][i] = temp; 
            } 
    } 
  
    // Function for do transpose of matrix 
    static void transpose(int arr[][]) 
    { 
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) { 
                int temp = arr[j][i]; 
                arr[j][i] = arr[i][j]; 
                arr[i][j] = temp; 
            } 
        System.out.println("");
        printMatrix(arr);
        }
    } 
    

	/**
	 * Time Complexity O(R*C) Space Complecity O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static int[][] rotateClockWiseUsingExtraSpace(int[][] arr) {
		int cols = arr[0].length;// original matrix column
		int rows = arr.length; // original matrix rows

		System.out.println("original matrix cols " + cols);
		System.out.println("original matrix rows " + rows);

		// revert columns and rows
		int[][] rotatedMatrix = new int[cols][rows];
		System.out.println("--------");
		System.out.println("new matrix cols " + rotatedMatrix[0].length);
		System.out.println("new matrix rows  " + rotatedMatrix.length);

		System.out.println("----");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// in a row, column is changing in original
				// in new matrix row will change => first column will be in first row
				// column => first row will be in last column
				
				// when move forward  (j, column),  will shift to downwards (row changes, row++)
				// when move downward (i, row),     will shift from right to left(column changes, total column--)
				int row = j;
				int col = rows - 1 - i;
				rotatedMatrix[row][col] = arr[i][j];
				printMatrix(rotatedMatrix);
			}
		}

		return rotatedMatrix;

	}

	/**
	 * Time Complexity O(R*C) Space Complecity O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static int[][] rotateAntiClockWiseUsingExtraSpace(int[][] arr) {
		int cols = arr[0].length;// original matrix column
		int rows = arr.length; // original matrix rows

		System.out.println("original matrix cols " + cols);
		System.out.println("original matrix rows " + rows);

		// revert columns and rows
		int[][] rotatedMatrix = new int[cols][rows];
		System.out.println("--------");
		System.out.println("new matrix cols " + rotatedMatrix[0].length);
		System.out.println("new matrix rows  " + rotatedMatrix.length);

		System.out.println("----");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// in a row, column is changing in original
				// in new matrix row will change => first column will be in last row
				// column => first row will be in first column
				int row = cols - 1 - j;
				int col = i;
				rotatedMatrix[row][col] = arr[i][j];
				// printMatrix(rotatedMatrix);
			}
		}

		return rotatedMatrix;

	}
}
