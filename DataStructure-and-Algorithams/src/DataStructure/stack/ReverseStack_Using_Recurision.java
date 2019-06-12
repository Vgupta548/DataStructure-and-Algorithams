package DataStructure.stack;

import java.util.Stack;

public class ReverseStack_Using_Recurision {

	private static void reverseStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int curr = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, curr);
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int x) {
		if (!stack.isEmpty()) {
			int curr = stack.pop();
			insertAtBottom(stack, x);
			stack.push(curr);
		} else {
			stack.push(x);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1); 
        st.push(2); 
        st.push(3); 
        st.push(4); 
          
        System.out.println("Original Stack"); 
          
        System.out.println(st); 
          
        // function to reverse  
        // the stack 
        reverseStack(st); 
          
        System.out.println("Reversed Stack"); 
          
        System.out.println(st); 

	}

}
