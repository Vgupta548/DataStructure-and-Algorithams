package DataStructure.tree.binaryTree;

import DataStructure.tree.Node;

public class BinaryTree {

	Node root;
	
	BinaryTree(int key){
		root = new Node(key);
	}
	
	BinaryTree(){
		root = null;
	}

}
