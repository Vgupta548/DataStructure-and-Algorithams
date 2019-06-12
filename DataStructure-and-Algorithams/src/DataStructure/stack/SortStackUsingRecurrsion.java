/**
 * 
 */
package DataStructure.stack;

import java.util.Stack;

/**
 * @author vipingupta
 *
 */
public class SortStackUsingRecurrsion {

	private static void sort(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int curr = stack.pop();
			sort(stack);
			addOnSortingPosition(stack, curr);
		}
	}

	private static void addOnSortingPosition(Stack<Integer> stack, int x) {
		if(!stack.isEmpty() && stack.peek() >x  ) {
			int curr = stack.pop();
			addOnSortingPosition(stack, x);
			stack.push(curr);
			
		}else {
			stack.push(x);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1); 
        st.push(12); 
        st.push(6); 
        st.push(9); 
        st.push(6); 
        st.push(8); 
          
        System.out.println("Original Stack"); 
          
        System.out.println(st); 
          
        // function to reverse  
        // the stack 
        sort(st); 
          
        System.out.println("Sorted Stack"); 
          
        System.out.println(st); 

	}

}
