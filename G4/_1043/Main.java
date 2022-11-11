package G4._1043;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int num = sc.nextInt();
		//bfs를 위해서 queue에 담는다.
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		for (int i = 0; i < num; i++) {
			int person = sc.nextInt() - 1;
			queue.add(person);
			visited[person] = true;
		}
		//파티에 오는 사람들을 저장하는 배열
		int[][] party = new int[M][];
		for (int i = 0; i < M; i++) {
			int len = sc.nextInt();
			party[i] = new int[len];
			for (int j = 0; j < len; j++) {
				party[i][j] = sc.nextInt() - 1;
			}
		}
		//그래프를 표현하기 위한 인접 리스트
		ArrayList<Integer>[] adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		//같은 파티에 오는 사람들을 연결해준다.
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].length - 1; j++) {
				for (int j2 = j + 1; j2 < party[i].length; j2++) {
					adjList[party[i][j]].add(party[i][j2]);
					adjList[party[i][j2]].add(party[i][j]);
				}
			}
		}
		//bfs를 통해 이야기가 가능한 사람만 남긴다.
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(Integer next : adjList[cur]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
		//이야기가 가능한 사람만 있는 파티만 참석한다.
		int ans = 0;
		outer : for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].length; j++) {
				if(visited[party[i][j]]) continue outer;
			}
			ans++;
		}
		//결과 출력
		System.out.println(ans);
		//자원 반환
		sc.close();
	}
}
