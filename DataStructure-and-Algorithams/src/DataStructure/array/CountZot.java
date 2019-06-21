package DataStructure.array;

import java.util.Arrays;

public class CountZot {

	public static void main(String[] args) {
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
        int arr_size = arr.length; 
        System.out.println(Arrays.toString(arr));
        sort012(arr); 
        System.out.println("Array after seggregation "); 
        System.out.println(Arrays.toString(arr));
        
        int arr1[] = { 0, 1, 0, 1, 1, 1 }; 
        System.out.println(Arrays.toString(arr1));
        sort01(arr1); 
        System.out.println("Array after seggregation "); 
        System.out.println(Arrays.toString(arr1));

	}
	
	static void sort012(int[] a) {
		int n = a.length;
		int lo = 0;
		int hi = n-1;
		int mid = 0;
		int temp=0;
		
		while(mid <= hi) {
			
			switch(a[mid]) {
			case 0:
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = a[hi];
				a[hi] = a[mid];
				a[mid] = temp;
				hi--;
				break;
			}
		}
		
	}
	
	static void sort01(int[] a) {
		int n = a.length;
		int lo = 0;
		int hi = n-1;
		int temp=0;
		
		while(lo <= hi) {
			
			switch(a[lo]) {
			case 1:
				temp = a[lo];
				a[lo] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			case 0:
				lo++;
			
			}
		}
		
	}

}
