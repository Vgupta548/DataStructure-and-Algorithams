package DataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

import DataStructure.tree.Node;

public class Serialize_Deseerialize {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
		
        System.out.println("diameter of binary tree is "); 
       
        LinkedList<Character> list = new LinkedList<Character>();
        serialize(tree.root, list);
        
        tree = desearialize(list);
        System.err.println("tree");
        
        BinaryTree tree1 = new BinaryTree();
        tree1 = deSearialize(list);
        System.err.println("tree");
        
        BinaryTree tree2 = new BinaryTree();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2); 
        tree2.root.right = new Node(3); 
        tree2.root.left.left = new Node(4); 
        tree2.root.left.right = new Node(5); 
        tree2.root.right.left = new Node(6); 
        tree2.root.right.right = new Node(7); 
        tree2.root.left.left.left = new Node(8); 
        tree2.root.left.left.right = new Node(9); 
        tree2.root.left.right.left = new Node(10); 
        
        String s = serializeCompleteBinaryTree(tree2.root);
        deSerializeCompleteBinaryTree(s);
	}
	
	
	public static String serializeCompleteBinaryTree(Node node) {
		StringJoiner file = new StringJoiner(",");
		Queue<Node> q = new LinkedList<Node>();
		
		if(node != null) {
			q.add(node);
			file.add(String.valueOf(node.key));
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.key);
			if(n.left != null) {
				q.add(n.left);
				file.add(""+n.left.key);
			}
			if(n.right != null) {
				q.add(n.right);
				file.add(""+n.right.key);
			}
		}
		
			return file.toString();
	}
	
	
	public static Node deSerializeCompleteBinaryTree(String file) {
		
		String[] arr = file.split(",");
		Node root = null;
		Queue<Node> q = new LinkedList<Node>();
		
		if(arr.length >0) {
			int level = 1;
			root = new Node(Integer.parseInt(arr[0]));
			q.add(root);
			int total = 1;
			
			while(total<arr.length) {
				int i =1;
				for(; i<= level*2 && total<= arr.length; ) {
					total++;
					if(arr.length >= total) {
						Node node = q.poll();
						node.left = new Node(Integer.parseInt(arr[total-1]));
						q.add(node.left);
						total++;
						i++;
						if(arr.length >= total) {
							node.right = new Node(Integer.parseInt(arr[total-1]));
							q.add(node.right);
							i++;
						}
					}
				}
				level = i-1;
			}
			
			
		}
		
		return root;
		
	}
	
	public static BinaryTree deSearialize(LinkedList<Character> list) {
		BinaryTree tree = new BinaryTree();
		if(list.size() > 0) {
			Counter counter = new Counter();
			tree.root = deSerialize(list, counter);
		}
		return tree;
		
	}
	
	public static void serialize(Node node,  LinkedList<Character> list) {
		if(node == null) {
			System.out.println(")");
			list.add(')');
			return;
		}
		
		System.out.println(node.key);
		list.add((char) node.key);
		
		serialize(node.left, list);
		serialize(node.right, list);
	}
	
	public static BinaryTree desearialize(LinkedList<Character> list) {
		BinaryTree tree = new BinaryTree();
		if(list.size() > 0) {
			tree.root = new Node((int)list.get(0));
			Counter counter = new Counter();
			desearialize(tree.root, list, counter);
		}
		return tree;
		
	}
	
	static class Counter{
		int i =0;
	}
	
	public static void desearialize(Node node, LinkedList<Character> list, Counter counter) {
		counter.i += 1; 
		if(list.size() <= counter.i) {
			return;
		}else {
			if(list.get(counter.i) != ')') {
				node.left = new Node((int)list.get(counter.i));
				desearialize(node.left, list, counter);
				
				counter.i += 1; 
				if(list.size() <= counter.i) {
					return;
				}else {
					if(list.get(counter.i) != ')') {
						node.right = new Node((int)list.get(counter.i));
						desearialize(node.right, list, counter);
					}else {
						node.right = null;
					}
				}
				
				
			}else {
				node.left = null;
					counter.i += 1; 
					if(list.get(counter.i) != ')') {
						node.right = new Node((int)list.get(counter.i));
						desearialize(node.right, list, counter);
					}else {
						node.right = null;
					}
			}
		}
		System.out.println("curr "+node.key  );
		
		
	}
	
	
	static Node deSerialize(LinkedList<Character> list, Counter counter) 
	{ 
	    // Read next item from file. If theere are no more items or next 
	    // item is marker, then return 
	    
	    if ( list.size() <= counter.i || list.get(counter.i) == ')') 
	       return null; 
	  
	    // Else create node with this item and recur for children 
	    Node root = new Node((int)list.get(counter.i));
	    
	    counter.i += 1; 
	    root.left = deSerialize( list, counter); 
	    counter.i += 1; 
	    root.right = deSerialize(list, counter); 
	    
	    return root;
	}
	

}
