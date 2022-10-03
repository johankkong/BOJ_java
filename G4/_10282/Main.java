package G4._10282;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()) - 1;
			//인접 리스트로 입력 받기
			ArrayList<int[]>[] adjList = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
			}
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				int sta = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int time = Integer.parseInt(st.nextToken());
				adjList[end].add(new int[] {sta, time});
			}
			//C에서 시작하는 다익스트라 알고리즘을 사용한다.
			boolean[] visited = new boolean[N];
			int[] dijk = new int[N];
			Arrays.fill(dijk, Integer.MAX_VALUE);
			PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.time - e2.time);
			pq.offer(new Node(C, 0));
			dijk[C] = 0;
			while(!pq.isEmpty()) {
				int idx = pq.peek().com;
				int localMin = pq.poll().time;
				if(visited[idx]) continue;
				//연결된 노드 갱신하기
				visited[idx] = true;
				for (int[] tmp : adjList[idx]) {
					if(!visited[tmp[0]]) {
						if(dijk[tmp[0]] > localMin + tmp[1]) {
							dijk[tmp[0]] = localMin + tmp[1];
							pq.offer(new Node(tmp[0], localMin + tmp[1]));
						}
					}
				}
			}
			//visited의 수와 가장 오래걸린 시간을 찾는다.
			int cnt = 0;
			int longest = 0;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					cnt++;
					longest = Math.max(longest, dijk[i]);
				}
			}
			//출력한다.
			System.out.println(cnt + " " + longest);
		}
	}
	static class Node {
		int com;
		int time;
		public Node(int com, int time) {
			super();
			this.com = com;
			this.time = time;
		}
	}
}
