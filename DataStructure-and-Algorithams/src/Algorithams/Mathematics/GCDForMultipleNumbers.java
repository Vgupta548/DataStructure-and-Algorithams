package Algorithams.Mathematics;

public class GCDForMultipleNumbers {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 8, 16 }; 
        System.out.println(gcdMultiple(arr));

	}
	
	static int gcdMultiple(int[] arr) {
		int result = arr[0];
		
		for(int i=1; i< arr.length; i++) {
			result = gcd(arr[i], result);
		}
		
		return result;
	}
	
	static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 

}
