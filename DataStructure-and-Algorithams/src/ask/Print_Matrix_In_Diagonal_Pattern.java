
package ask;

import java.util.Scanner;

/**
 * Company : Nayka
 * 
 * Given a matrix of n*n size, the task is to print its elements in diagonal pattern.
 * 
 * 
 * input
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 
 * output
 * 1 2 5 8 6 3 4 7 10 13 14 11 8 12 15 16
 * @author vipingupta
 * 
 * https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
 *
 */

public class Print_Matrix_In_Diagonal_Pattern {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		solve(arr, N, M);
	}

	public static void solve(int[][] arr, int n, int m) {
		boolean isUp = true;
		int i = 0, j = 0;
		for (int k = 0; k < n * m; k++) {
			if (isUp) {
				for (; i >= 0 && j < m; i--, j++) {
					System.out.print(arr[i][j] + " ");
				}
				i++;
				j--;
				if (j == m - 1) {
					i++;
				} else {
					j++;
				}
			} else {
				for (; j >= 0 && i < n; j--, i++) {
					System.out.print(arr[i][j] + " ");
				}
				i--;
				j++;
				if (i == n - 1) {
					j++;
				} else {
					i++;
				}
			}
			isUp = !isUp;
		}

	}

}
