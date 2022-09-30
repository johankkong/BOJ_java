package G4._1922;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//컴터 수
		int N = sc.nextInt();
		//간선 수
		int M = sc.nextInt();
		//리스트에 간선 저장하기
		List<Edge> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int st = sc.nextInt() - 1;
			int ed = sc.nextInt() - 1;
			int cost = sc.nextInt();
			list.add(new Edge(st, ed, cost));
		}
		//cost기준으로 정렬하기
		Collections.sort(list);
		//대표자 배열
		pre = new int[N];
		//make-set
		for (int i = 0; i < N; i++) {
			pre[i] = i;
		}
		int cnt = 0;
		int idx = 0;
		int sum = 0;
		while(cnt < N - 1) {
			Edge edge = list.get(idx);
			idx++;
			int st = edge.st;
			int ed = edge.ed;
			if(find(st) == find(ed)) continue;
			union(st, ed);
			sum += edge.cost;
			cnt++;
		}
		System.out.println(sum);
	}
	static int[] pre;
	//find-set
	static int find(int i) {
		if(pre[i] != i) {
			pre[i] = find(pre[i]);
		}
		return pre[i];
	}
	//union
	static void union(int i, int j) {
		pre[find(j)] = find(i);
	}
	static class Edge implements Comparable<Edge> {
		int st; //시작 정접
		int ed; //끝 정점
		int cost; //가중치
		public Edge(int st, int ed, int cost) {
			super();
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
