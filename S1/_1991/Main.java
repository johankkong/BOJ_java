package S1._1991;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeNum = sc.nextInt();
		Tree tree = new Tree();
		for(int i = 0; i< nodeNum; i++) {
			String nodeData = sc.next();
			Node curr;
			if(tree.size == 0) {
				tree = new Tree(new Node(nodeData));
				curr = tree.root;
			}
			else {
				tree.search(nodeData, tree.root);
				curr = tree.tmp;
				tree.tmp = null;
			}
			String child1 = sc.next();
			if(!child1.equals(".")) {
				Node child = new Node(child1);
				tree.linkL(curr, child);
			}
			String child2 = sc.next();
			if(!child2.equals(".")) {
				Node child = new Node(child2);
				tree.linkR(curr, child);
			}
		}
		preorder(tree, tree.root);
		System.out.println(sb);
		sb = new StringBuilder();
		inorder(tree, tree.root);
		System.out.println(sb);
		sb = new StringBuilder();
		postorder(tree, tree.root);
		System.out.println(sb);
	}
	
	static StringBuilder sb = new StringBuilder();
	static void preorder(Tree tree, Node head) {
		if(head != null) {
			sb.append(head.data);
			preorder(tree, head.left);
			preorder(tree, head.right);
		}
	}
	static void inorder(Tree tree, Node head) {
		if(head != null) {
			inorder(tree, head.left);
			sb.append(head.data);
			inorder(tree, head.right);
		}
	}
	static void postorder(Tree tree, Node head) {
		if(head != null) {
			postorder(tree, head.left);
			postorder(tree, head.right);
			sb.append(head.data);
		}
	}
}

class Node {
	String data;
	Node left;
	Node right;
	Node parent;
	public Node(String data) {
		this.data = data;
	}
}

class Tree {
	Node root;
	int size;
	public Tree() {
	}
	public Tree(Node root) {
		this.root = root;
	}
	public void linkL(Node p, Node c) {
		p.left = c;
		c.parent = p;
		size++;
		if(c == root) root = p;
	}
	public void linkR(Node p, Node c) {
		p.right = c;
		c.parent = p;
		size++;
		if(c == root) root = p;
	}
	static Node tmp;
	public void search(String data, Node head) {
		if(head != null && head.data.equals(data)) {
			tmp = head; 
			return;
		}
		if(head != null) {
			search(data, head.left);
			search(data, head.right);
		}
	}
}
