package G4._16202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Edge> list = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int sta = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = i;
			list.add(new Edge(sta, end, weight));
		}
		//결과를 저장할 배열
		int[] result = new int[K];
		int idx = 0;
		//K번 게임을 진행
		for (int i = 0; i < K; i++) {
			//크루스칼 알고리즘을 이용
			//make-set
			head = new int[N];
			for (int j = 0; j < N; j++) {
				head[j] = j;
			}
			//뽑은 간선의 갯수
			int cnt = 0;
			int j = 0;
			int score = 0;
			while(cnt < N - 1 && j < list.size()) {
				Edge edge = list.get(j++);
				//find-set
				int left = findSet(edge.sta);
				int right = findSet(edge.end);
				if(left == right) continue;
				//union
				union(left, right);
				cnt++;
				score += edge.weight;
			}
			//MST를 만들 수 없다면
			if(cnt < N - 1) break;
			//만들었다면 결과를 저장
			result[idx++] = score;
			//list에서 하나를 지운다.
			list.remove(0);
		}
		//idx가 K에 도달하지 못했다면 0으로 채운다.
		while(idx < K) {
			result[idx++] = 0;
		}
		//결과를 출력
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < K; i++) {
			ans.append(result[i]).append(" ");
		}
		System.out.println(ans);
	}
	private static void union(int left, int right) {
		head[findSet(right)] = findSet(left);
	}
	static int[] head;
	private static int findSet(int ver) {
		if(head[ver] != ver) 
			head[ver] = findSet(head[ver]);
		return head[ver];
	}
	//간선 클래스
	static class Edge {
		int sta;
		int end;
		int weight;
		public Edge(int sta, int end, int weight) {
			this.sta = sta;
			this.end = end;
			this.weight = weight;
		}
	}
}
