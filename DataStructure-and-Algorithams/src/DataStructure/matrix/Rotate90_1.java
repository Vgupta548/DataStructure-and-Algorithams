package DataStructure.matrix;

/**
 * For N*N matrix 
 * @author vipingupta
 *
 */
public class Rotate90_1 {
	
	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		
		System.out.println("Original Matrix :");
		printMatrix(matrix);

		rotateClockWiseWithoutUsingExtraSpace(matrix);
		System.out.println("clock Rotated Matrix :");
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
	
	public static void rotateClockWiseWithoutUsingExtraSpace(int[][] arr) {
		int length = arr.length-1;
		System.out.println("length = "+length);
		for(int i =0 ; i<=length/2; i++) {
			for(int j =i; j<length-1; j++) {
				System.out.println("arr = ["+i+"]["+j+"]");
				int p1 = arr[i][j];
				
				// when move forward  (j, column),  will shift to downwards (row changes, row++)
				// when move downward (i, row),     will shift from right to left(column changes, total column--)
				int p2 = arr[j][length-i];
				
				// when move forward  (j, column),  will shift from right to left(column changes, total column--)
				// when move downward (i, row),     will shift from bottom to top(row changes, total row--)
				int p3 = arr[length-i][length-j];
				
				// when move forward  (j, column),  will shift from bottom to top(row changes, total row--)
				// when move downward (i, row),     will shift from left to right(column changes, row++)
				int p4 = arr[length-j][i];
				
				arr[j][length] = p1;
				arr[length-i][length-j] = p2;
				arr[length-j][i] = p3;
				arr[i][j] = p4;
			}
		}
		
	}

}
