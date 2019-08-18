package DataStructure.tree;

import java.util.Stack;

public class isSubTree {

	boolean isSubTree(Node root, Node sub) {
		if(sub == null) return true;
		if(root == null) return false;
		if(isIdentical(root, sub)) return true;
		return isSubTree(root.left, sub) || isSubTree(root.right, sub);
	}
	
	boolean isIdentical(Node root, Node sub) {
		
		if(root == null && sub == null) return true;
		if(root == null || sub == null) return false;
		
		return root.key == sub.key && isIdentical(root.left, sub) && isIdentical(root.left, sub);
	}
	
boolean isSameStructure(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		
		return isSameStructure(root1.left, root2.left) && isSameStructure(root1.right, root2.right);
	}

	void zigZag(Node root) {
		if(root == null) return ;
		
		Stack<Node> stack1 = new Stack();
		Stack<Node> stack2 = new Stack();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(!stack1.isEmpty()) {
				Node n = stack1.pop();
				System.out.println(n.key + "");
				if(n.left != null) stack2.push(n.right);
				if(n.right != null) stack2.push(n.left);
			}
			
			while(!stack2.isEmpty()) {
				Node n = stack2.pop();
				System.out.println(n.key + "");
				if(n.right != null) stack2.push(n.left);
				if(n.left != null) stack2.push(n.right);
			}
		}
		
	}
	
}
