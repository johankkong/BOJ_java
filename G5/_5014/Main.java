package G5._5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		//BFS로 풀이
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[F + 1];
		queue.offer(S);
		visited[S] = true;
		int ans = 0;
		int floor = -1;
		out : while(!queue.isEmpty()) {
			int tmp = queue.size();
			for (int i = 0; i < tmp; i++) {
				floor = queue.poll();
				if(floor == G) break out;
				if(floor + U <= F && !visited[floor + U]) {
					queue.offer(floor + U);
					visited[floor + U] = true;
				}
				if(floor - D > 0 && !visited[floor - D]) {
					queue.offer(floor - D);
					visited[floor - D] = true;
				}
			}
			ans++;
		}
		if(floor != G) System.out.println("use the stairs");
		else System.out.println(ans);
	}
}
