package DataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import DataStructure.tree.Node;

public class LeafCount {

	/* Driver program to test above functions */
    public static void main(String args[])  
    { 
        /* create a tree */
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
           
        /* get leaf count of the abve tree */
        System.out.println("The leaf count of binary tree is : " 
                             + getLeafCount(tree.root)); 
        System.out.println("The leaf count of binary tree is : " 
                + getLeafNodeCount(tree.root));
    } 
    
	public static int getLeafCount(Node node) {
		if(node == null) return 0;
		if(node.left == null && node.right == null) return 1;
		return getLeafCount(node.left) + getLeafCount(node.right);
	}
	
	public static int getLeafNodeCount(Node node) {
		int count  =0 ;
		Queue<Node> q = new LinkedList<Node>();
		if(node !=null) q.add(node);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.left == null && n.right == null) count++;
			if(n.left != null) q.add(n.left);
			if(n.right != null) q.add(n.right);
		}
		
		return count;
	}
}
