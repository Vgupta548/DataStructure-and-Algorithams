package Algorithams.Mathematics;

import java.util.Arrays;

public class Main
{
	// Function to calculate the frequency of all elements in the array
	public static void findFrequency(int[] A)
	{
		// create an count array of size n to store count of all array elements
		int[] freq = new int[A.length];

		// update frequency of each element
		for (int e: A) {
			freq[e]++;
		}
System.out.println(Arrays.toString(freq));
		// iterate through the array to print frequencies
		for (int i = 0; i < A.length; i++) {
			if (freq[i] > 0) {
				System.out.printf("%d appears %d times\n", i, freq[i]);
			}
		}
	}

	public static void main(String[] args)
	{
		int[] A = { 2, 3, 3, 2, 1 };
		findFrequency(A);
	}
}