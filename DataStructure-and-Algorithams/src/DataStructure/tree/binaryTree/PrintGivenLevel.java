package DataStructure.tree.binaryTree;

import DataStructure.tree.Node;

public class PrintGivenLevel {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		int level = 3;
        System.out.println(level+" level of binary tree is "); 
        printGivenLevel(tree.root, 3);
  
	}

	private static void printGivenLevel(Node root, int level) {
		if(root == null) return ;
		if(level == 1) System.out.println(root.key);
		else if(level > 1) {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}

}
