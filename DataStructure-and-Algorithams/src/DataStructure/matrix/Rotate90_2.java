package DataStructure.matrix;

public class Rotate90_2 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println("Original Matrix :");
		printMatrix(matrix);

		rotateByTranspose(matrix, true);
		System.out.println("clock Rotated Matrix :");
		printMatrix(matrix);

		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotateByTranspose(matrix2, false);
		System.out.println("Anti clock Rotated Matrix :");
		printMatrix(matrix2);

	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rotateByTranspose(int[][] arr, boolean isClockWise) {
		/* transpose the matrix */
		transpose(arr);
		printMatrix(arr);
		if (isClockWise) {
			/* reverse columns for clock wise rotation */
			reverseColumnsForClockWiseRotation(arr);
		} else {
			/* reverse rows for anti clock wise rotation */
			reverseRowForAntiClockWiseRotation(arr);
		}
	}

	public static void transpose(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

	public static void reverseRowForAntiClockWiseRotation(int[][] arr) {
		int rows = arr.length;
		int columns = arr[0].length;

		for (int i = 0; i < (rows/2 -1 ); i++) {
			for (int j = 0; j < columns; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[rows-1-i][j];
				arr[rows-1-i][j] = temp;
			}
		}
	}

	public static void reverseColumnsForClockWiseRotation(int[][] arr) {
		int rows = arr.length;
		int columns = arr[0].length;
		System.out.println();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= (columns / 2 - 1); j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][columns - 1 - j];
				arr[i][columns - 1 - j] = temp;
			}
		}
	}
}
