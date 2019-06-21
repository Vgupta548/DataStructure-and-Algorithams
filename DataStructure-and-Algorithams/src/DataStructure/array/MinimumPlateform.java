package DataStructure.array;

import java.util.Arrays;

public class MinimumPlateform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int minPlateform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int plateform = 1;
		int ans =1;
		int i=1;
		int j=0;
		while(i <n && j<n) {
			if(arr[i] < dep[j]) {
				plateform++;
				if(plateform > ans) {
					ans = plateform;
				}
				i++;
			}else {
				plateform--;
				j++;
			}
		}
		
		return ans;
	}

}
