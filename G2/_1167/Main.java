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
			st.nextToken();
			int end = Integer.parseInt(st.nextToken()) - 1;
			while(end != -2) {
				int weight = Integer.parseInt(st.nextToken());
				adjList[i].add(new int[]{end, weight});
				end = Integer.parseInt(st.nextToken()) - 1;
			}
		}


	}
}
