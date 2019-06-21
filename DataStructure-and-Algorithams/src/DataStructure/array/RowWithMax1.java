package DataStructure.array;

public class RowWithMax1 {

	public static void main(String[] args) {
		{ 
	        int mat[][] = { { 0, 0, 0, 1 }, 
	                        { 0, 1, 1, 1 }, 
	                        { 1, 1, 1, 1 }, 
	                        { 0, 0, 0, 0 } }; 
	        System.out.println("Index of row with maximum 1s is "
	                                            + rowWithMax1s(mat)); 
	        System.out.println("Index of row with maximum 1s is "
                    + rowWithMax1s1(mat)); 
	    } 

	}

	private static int rowWithMax1s(int[][] mat) {
		int R = mat.length;
		int C = mat[0].length;
		System.out.println(R +" :" +C);
		int max = -1;
		int max_row_index = 0;
		System.out.println();
		for(int i =0; i <R; i++) {
			System.out.print(i +" : ");
			int index = first(mat[i], 0, C-1);
			System.out.println(index);
			if(index != -1 && C - index > max) {
				max = C - index;
				max_row_index = i;
			}
			
		}
		return max_row_index;
	}
	
	private static int rowWithMax1s1(int[][] mat) {
		int R = mat.length;
		int C = mat[0].length;
		System.out.println(R +" :" +C);
		int max = -1;
		int max_row_index = 0;
		
		int index = first(mat[0], 0, C-1);
		if(index == -1) index = C-1;
		
		for(int i =1; i <R; i++) {
			
			while(index >= 0 && mat[i][index] == 1) {
				index = index-1;
				max_row_index = i;
			}
			
		}
		return max_row_index;
	}
	
	 static int first(int arr[], int low, int high) {
		 if(high >= low) {
			 int mid = low + (high - low)/2;
			 
			 if((mid == 0 || arr[mid-1] == 0) && arr[mid] == 1)
				 return mid;
			 else if(arr[mid] == 0) {
				 return first(arr, mid+1, high);
			 }else {
				 return first(arr, low, mid-1);
			 }
		 }
		 return -1;
	 }

}
