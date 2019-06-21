package DataStructure.tree.binaryTree;

import DataStructure.tree.Node;

public class Diameter {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.left.right = new Node(4);
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left = new Node(5); 
        tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.right.left = new Node(8);
		
        System.out.println("diameter of binary tree is "); 
        System.out.println(diameter(tree.root));
        
        System.out.println("diameter of binary tree is by optimized version "); 
        System.out.println(diameter1(tree.root, new HeightClass()));
  
	}

	private static int diameter(Node root) {
		if(root == null) return 0;
		/* Return max of following three 
        1) Diameter of left subtree 
       2) Diameter of right subtree 
       3) Height of left subtree + height of right subtree + 1 */
		return Math.max(
				height(root.left) + 1 + height(root.right), 
				Math.max(
						diameter(root.left), 
						diameter(root.right)
						)
				) ;
		
	}
	
	/**
	 * Optimized implementation: The above implementation can be optimized by calculating the height in the same recursion
	 * rather than calling a height() separately. 
	 * This optimization reduces time complexity to O(n).
	 * @param root
	 * @return
	 */
	private static int diameter1(Node root, HeightClass height) {
		
		HeightClass lh = new HeightClass();
		HeightClass rh = new HeightClass();
		if(root == null) {
			height.h = 0;
			return 0;
		}else {
			int ldiameter = diameter1(root.left, lh);
			int rdiameter = diameter1(root.right, rh);
			
			height.h = Math.max(lh.h,  rh.h) +1;
			
			return Math.max(Math.max(ldiameter, rdiameter), lh.h + rh.h + 1);
			
		}
		
		
	}
	
	
	private static int height(Node root) {
		if(root == null) return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		return lheight > rheight ? lheight+1 : rheight+1;
	}

}

class HeightClass{
	int h;
}

