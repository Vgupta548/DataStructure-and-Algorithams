package ask;

/**
 * company : pramati
 * 
 * Required initial power to survive till the end
 * 
 * @author vipingupta
 *
 */

public class Shaktiman {

	public static void main(String[] args) {
		int[] arr = {1,-2,4,-4,-5,-3,2,3,4,-4,-6,4,-3,-5,2,-1};
		int n = arr.length;
		
		int currentSum = 0;
		int minSum = arr[0]< 0 ? arr[0] : 0;
		
		currentSum = arr[0]; 
		for(int i =0 ; i<n; i ++) {
			
			currentSum += arr[i];
			minSum = currentSum < minSum ? currentSum : minSum;
		}
		
		System.out.println(minSum -1);
	}
}
