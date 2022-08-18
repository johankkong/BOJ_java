package S4._1158;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList list = new LinkedList();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		list.link();
		Node curr = list.tail;
		sb.append("<");
		while (list.size != 1) {
			for (int i = 0; i < K - 1; i++) {
				curr = curr.next;
			}
			sb.append(list.kill(curr));
			sb.append(", ");
		}
		sb.append(curr.data);
		sb.append(">");
		System.out.println(sb);
	}

}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head;
	Node tail;
	int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	void add(int i) {
		Node node = new Node(i);
		if (size == 0)
			head = tail = node;
		else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	int kill(Node node) {
		int out = node.next.data;
		node.next = node.next.next;
		size--;
		return out;
	}

	void link() {
		tail.next = head;
	}
}
