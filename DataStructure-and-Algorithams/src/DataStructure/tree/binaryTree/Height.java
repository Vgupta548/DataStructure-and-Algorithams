package DataStructure.tree.binaryTree;

import DataStructure.tree.Node;

/**
 *  Compute the "height" of a tree -- the number of 
 *  nodes along the longest path from the root node 
 *  down to the farthest leaf node.
 *
 * @author vipingupta
 *
 */
public class Height {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
  
        System.out.println("Preorder traversal of binary tree is "); 
        height(tree.root);
  
	}

	private static int height(Node root) {
		if(root == null) return 0;
		
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		return lheight > rheight ? lheight+1 : rheight+1;
		
	}
	

}
