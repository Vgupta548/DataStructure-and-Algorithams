package DataStructure.tree.binaryTree;

import DataStructure.tree.Node;

public class BalanceTree {

	public static void main(String args[]) 
    { 
		TreeHeight height = new TreeHeight(); 
  
        /* Constructed binary tree is 
                   1 
                 /   \ 
                2      3 
              /  \    / 
            4     5  6 
            / 
           7         */
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(6); 
        tree.root.left.left.left = new Node(7); 
  
        if (isBalanced(tree.root, height)) 
            System.out.println("Tree is balanced"); 
        else
            System.out.println("Tree is not balanced"); 
    } 
	
	public static boolean isBalanced(Node node, TreeHeight height) {
		
		if(node == null) return true;
		
		TreeHeight lh = new TreeHeight();
		TreeHeight rh = new TreeHeight();
		boolean l = isBalanced(node, lh);
		boolean r = isBalanced(node, rh);
		
		if(!l || !r) return false;
		
		if(Math.abs(Math.abs(lh.height-rh.height)) >=2) {
			return false;
		}
		
		height.height = (lh.height > rh.height? lh.height : rh.height) +1;
		
		return true;
		
	}
}

class TreeHeight{
	int height = 0;
}