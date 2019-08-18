package DataStructure.tree.binaryTree;

import java.util.Stack;

import DataStructure.tree.Node;

public class PreOrderToBST {

	BinaryTree tree = new BinaryTree();  
	 public static void main(String[] args) { 
	        int pre[] = new int[]{10, 5, 1, 7, 40, 50}; 
	        int size = pre.length; 
	        Node root = constructTree(pre, size); 
	        System.out.println("Inorder traversal of the constructed tree is "); 
	        printInorder(root); 
	    } 
	 

		private static void printInorder(Node root) {
		if(root ==null) {
			return;
		}
		
		printInorder(root.left);
		System.out.println(root.key);
		printInorder(root.right);
		
		
	}


		static  Node constructTree(int[] pre, int size) {
			Stack<Node> stack = new Stack<Node>();
			Node root = new Node(pre[0]);
			stack.push(root);
			
			for(int i=1; i<size; i++) {
				Node temp = null;
				
				while(!stack.isEmpty() &&  stack.peek().key < pre[i]) {
					temp = stack.pop();
				}
					
				if(temp != null) {
					temp.right = new Node(pre[i]);
					stack.push(temp.right);
				}else {
					
					temp = stack.peek();
					temp.left = new Node(pre[i]);
					stack.push(temp.left);
				}
			}
			
			return root;
		}
}
