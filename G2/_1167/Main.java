package G2._1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static ArrayList<int[]>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(in.readLine());
		//인접리스트로 그래프 표현
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			while(end != -2) {
				int weight = Integer.parseInt(st.nextToken());
				adjList[start].add(new int[]{end, weight});
				end = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		// 1. 한 정점에서 가장 먼 점을 구한다.
		visited = new boolean[V];
		result = new int[2];
		dfs(0, 0);
		// 2. 1번에서 구한 가장 먼 점에서 가장 먼 점을 구한다.
		visited = new boolean[V];
		dfs(result[0], 0);
		// 3. 그 때의 거리가 트리의 지름이다.
		System.out.println(result[1]);
	}
	static boolean[] visited;
	static int[] result;
	private static void dfs(int curr, int weight) {
		visited[curr] = true;
		for (int i = 0; i < adjList[curr].size(); i++) {
			if(!visited[adjList[curr].get(i)[0]]) {
				dfs(adjList[curr].get(i)[0], weight + adjList[curr].get(i)[1]);
			}
		}
		visited[curr] = false;
		if(result[1] < weight) {
			result[0] = curr;
			result[1] = weight;
		}
	}
}

