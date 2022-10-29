package S2._1260;

import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken()) - 1;
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int sta = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			adjList[sta].add(end);
			adjList[end].add(sta);
		}
		//내림차순으로 정렬
		for (int i = 0; i < V; i++) {
			Collections.sort(adjList[i], Collections.reverseOrder());
		}
		StringBuilder ans = new StringBuilder();
		//DFS
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(!visited[cur]) {
				ans.append(cur + 1).append(" ");
			}
			visited[cur] = true;
			for (int i = 0; i < adjList[cur].size(); i++) {
				int next = adjList[cur].get(i);
				if(!visited[next]) {
					stack.add(next);
				}
			}
		}
		ans.append("\n");
		//오름차순으로 정렬
		for (int i = 0; i < V; i++) {
			Collections.sort(adjList[i]);
		}
		//BFS
		visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			ans.append(cur + 1).append(" ");
			for (int i = 0; i < adjList[cur].size(); i++) {
				int next = adjList[cur].get(i);
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
		System.out.println(ans);
	}
}
