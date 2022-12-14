package S1._1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		ans = 0;
		visited = new boolean[100001];
		bfs(new Node(N, 0));
		System.out.println(ans);
	}
	static int ans;
	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		visited[node.value] = true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int v = n.value;
			int t = n.time;
			ans = t;
			if(v == K) break;
			if(v * 2 < 100001 && !visited[v * 2]) {
				queue.add(new Node(v * 2, t + 1));
				visited[v * 2] = true;
			}
			if(v + 1 < 100001 && !visited[v + 1]) {
				queue.add(new Node(v + 1, t + 1));
				visited[v + 1] = true;
			}
			if(v - 1 < 100001 && v - 1 >= 0 && !visited[v - 1]) {
				queue.add(new Node(v - 1, t + 1));
				visited[v - 1] = true;
			}
		}
	}

	static class Node {
		int value;
		int time;
		public Node(int value, int time) {
			super();
			this.value = value;
			this.time = time;
		}
	}
}
