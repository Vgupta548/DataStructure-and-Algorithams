package DataStructure.tree.binaryTree;

import DataStructure.tree.Node;

public class Diameter {

	public static boolean isLeftFound = false;
	public static boolean isRightFound = false;
	
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
	
	
	
	static int findLCA(Node root, int num1, int num2){
		
		if(root.left == null && root.right == null) {
			return Integer.MIN_VALUE;
		}
		
		//check in left 
		boolean isLeft = isFound(root.left, num1, num2) ;
		if(isLeft) {
			
		}
		
		if(isLeftFound && isRightFound) {
			return root.key;
		}
		
		isFound(root.left, num1, num2) ;
		if(isLeftFound && isRightFound) {
			return root.key;
		}
		
		
		int left = findLCA(root.left, num1, num2);
		if( left != -1) {
			return left;
		}
		
		int right = findLCA(root.right, num1, num2);
		if( right != -1) {
			return right;
		}
		
		//check in right
		
		return 1;
		
	}
	
	static boolean isFound(Node root, int num1, int num2){
		if(root != null && (root.key == num1 || root.key == num2)) {
			return true;
		}
		
		if(!isLeftFound && root.key == num1) {
			isLeftFound = true;
			return true;
		}
		
		if(!isRightFound && root.key == num1) {
			isRightFound = true;
			return true;
		}
		//check in left 
		
		
		//check in right
		
		return true;
		
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

