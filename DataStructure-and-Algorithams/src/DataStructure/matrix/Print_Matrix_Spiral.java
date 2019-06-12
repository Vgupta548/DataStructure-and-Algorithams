package DataStructure.matrix;
import java.util.Scanner;

public class Print_Matrix_Spiral {

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in) ;

		// int N = in.nextInt();
		// int M = in.nextInt();
		int[][] arr = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }, { 13, 14, 15, 16 } };

		solve(arr, 4, 4);

		System.out.println("====");

		int[][] arr1 = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 } };

		solve(arr1, 2, 4);
		
		System.out.println("====");

		int[][] arr2 = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }};

		solve(arr2, 3, 4);

		System.out.println("====");

		int[][] arr3 = { { 1, 2, 3, 10 } };

		solve(arr3, 1, 4);
		
		System.out.println("====");

		int[][] arr4 = { { 1}, {2}, {3}, {10}  };

		solve(arr4, 4, 1);

	}

	public static void solve(int[][] arr, int endRow, int endColumn) {
		int startRow = 0, startColumn = 0, k = 0;

		while (startRow < endRow && startColumn < endColumn) {

			for (k = startColumn; k < endColumn; ++k) {
				System.out.print(arr[startRow][k] + " ");
			}
			startRow++;
			System.out.println();

			for (k = startRow; k < endRow; k++) {
				System.out.print(arr[k][endColumn - 1] + " ");
			}
			endColumn--;
			System.out.println();

			if (startRow < endRow) {
				for (k = endColumn - 1; k >= startColumn; --k) {
					System.out.print(arr[endRow - 1][k] + " ");
				}
				endRow--;
			}
			System.out.println();

			if (startColumn < endColumn) {
				for (k = endRow - 1; k >= startRow; --k) {
					System.out.print(arr[k][startColumn] + " ");
				}
				startColumn++;
			}
			System.out.println();
		}
	}

}
