package DataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import DataStructure.tree.Node;

public class BFSTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("Breadth First Traversal (Or Level Order Traversal) of binary tree is ");
		BFT(tree.root);

		System.out.println("Depth First Traversals of binary tree is ");
		DFT(tree.root);

	}

	private static void DFT(Node root) {
		if(root == null) return ;
		System.out.println(root.key);
		DFT(root.left);
		DFT(root.right);
	}

	private static void BFT(Node root) {
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node item = queue.poll();
				System.out.println(item.key);
				
				if(item.left !=null)
					queue.add(item.left);
				if(item.right !=null)
					queue.add(item.right);
			}

		}
	}
}
