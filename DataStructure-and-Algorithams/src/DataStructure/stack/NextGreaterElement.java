package DataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElement {

	static void printNGE(int arr[], int n) {

		Stack<Integer> stack = new Stack<Integer>();
		for(int i =0; i<n ; i++) {
			int curr = arr[i];
			while(!stack.isEmpty()) {
				int lastElement = stack.peek();
				if(curr <= lastElement ) break;
				System.out.println(lastElement +" -> "+ curr);
				stack.pop();
			}
			
			stack.add(curr);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			// int arr[] = { 11, 13, 21, 3 };
			//11 13 21 3
			String line = bufferReader.readLine();
			line.trim();
			bufferReader.close();
			String[] arr = line.split("\\s");
			int[] intarr = new int[arr.length];
			for(int i=0; i<intarr.length ; i++) {
				intarr[i] = Integer.parseInt(arr[i]);
			}
			//System.out.println(arr[0]);
			int n = arr.length;
			 printNGE(intarr, n);
		} catch (IOException e) {
			System.out.println("Exception occured :" + e);
		} finally {
			bufferReader.close();
		}

	}

}
