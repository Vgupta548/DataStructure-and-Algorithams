package DataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import DataStructure.tree.Node;

public class BinaryTreeTraversal {

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
		printPreOrder(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		printInOrder(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		printPostOrder(tree.root);

		System.out.println("Breadth First Traversal (Or Level Order Traversal) of binary tree is ");
		BFT(tree.root);

		System.out.println("Depth First Traversals of binary tree is ");
		DFT(tree.root);
	}

	public static void printPreOrder(Node node) {
		if (node == null)
			return;

		System.out.println(node.key);
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public static void printPreOrderByStack(Node node) {
		if (node == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node curr = node;

		while (curr != null || stack.size()>0) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.println(curr.key);
			curr = curr.right;
		}

	}

	public static void printInOrder(Node node) {
		if (node == null)
			return;

		printInOrder(node.left);
		System.out.println(node.key);
		printInOrder(node.right);
	}

	public static void printPostOrder(Node node) {
		if (node == null)
			return;

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.key);
	}

	private static void DFT(Node root) {
		if (root == null)
			return;
		System.out.println(root.key);
		DFT(root.left);
		DFT(root.right);
	}

	private static void BFT(Node root) {
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);

			while (!queue.isEmpty()) {
				Node item = queue.poll();
				System.out.println(item.key);

				if (item.left != null)
					queue.add(item.left);
				if (item.right != null)
					queue.add(item.right);
			}

		}
	}

}
