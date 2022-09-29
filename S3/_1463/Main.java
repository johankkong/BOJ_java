package S3._1463;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ans = 0;
		bfs(new Node(num, 0));
		System.out.println(ans);
	}
	//dfs로 탐색하는 경우 -1 만 반복하다가 시간초과가 날 것이 분명..
	//따라서 bfs로 진행
	static int ans;
	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			ans = n.operTime;
			int value = n.value;
			if(value == 1)
				break;
			//1을 빼는 연산
			queue.offer(new Node(value - 1, n.operTime + 1));
			//2의 배수라면 2로 나누는 연산
			if(value % 2 == 0)
				queue.offer(new Node(value / 2, n.operTime + 1));
			//3의 배수라면 3으로 나누는 연산
			if(value % 3 == 0)
				queue.offer(new Node(value / 3, n.operTime + 1));
		}
	}
	//연산된 값과 연산된 횟수를 저장하는 클래스
	static class Node {
		int value;
		int operTime;
		public Node(int value, int operTime) {
			this.value = value;
			this.operTime = operTime;
		}
	}
}
