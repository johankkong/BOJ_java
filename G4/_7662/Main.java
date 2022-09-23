package G4._7662;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T;  tc++) {
			
		}
	}
}

class DoublePQ {
	Node head;
	Node tail;
	int size;
	void insert(int value) {
		Node node = new Node(value);
		if(size == 0) {
			size = 1;
			head = node;
			tail = node;
		} else {
			Node tmp = head;
			while(tmp.value > value) 
				tmp = tmp.next;	
			if(tmp == null) {
				tail.next = node;
				node.front = tail;
				tail = node;
			} else {
				
			}
			
		}
	}
}

class Node {
	int value;
	Node front;
	Node next;
	public Node(int value) {
		this.value = value;
		front = null;
		next = null;
	}
}