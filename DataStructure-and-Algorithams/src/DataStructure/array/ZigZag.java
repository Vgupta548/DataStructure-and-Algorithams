package DataStructure.array;

import java.util.Arrays;

public class ZigZag {

	static int arr1[] = new int[]{4, 3, 7, 8, 6, 2, 1}; 
	public static void main(String[] args) {
		zigZag(arr1); 
        System.out.println(Arrays.toString(arr1)); 

	}

	private static void zigZag(int[] arr) {

		boolean requiredSmall = false;
		for (int i = 1; i < arr.length; i++) {
			boolean isSmall = arr[i] < arr[i - 1];
			if(requiredSmall) {
				if(!isSmall) {
					switchValue(arr, i, i-1);
				}
			}else {
				if(isSmall) {
					switchValue(arr, i, i-1);
				}
			}
			requiredSmall = !requiredSmall;
		}

	}

	private static void switchValue(int[] arr, int index1, int index2) {

		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
