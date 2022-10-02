package S1._2468;

import java.io.*;
import java.util.*;

public class Main {
	//1부터 100까지 늘려가면서, 해당 수보다 작거나 같은 칸은 제외하고
	//bfs를 이용하여 땅의 갯수를 센다.
	//땅의 갯수가 가장 클 때의 갯수를 출력한다.
	//땅의 갯수가 0이 되면 중지한다.
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//땅의 최대 갯수
		int ans = 1;
		//1부터 100까지 1씩 늘려가면서
		out : for (int day = 1; day <= 100; day++) {
			//방문처리에 사용할 배열
			visited = new boolean[N][N];
			//땅의 갯수
			int land = 0;
			//각 칸에 대해서 bfs를 살행하여 땅의 갯수를 센다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && arr[i][j] > day) {
						bfs(i, j, day);
						land++;
					}
				}
			}
			//땅의 갯수가 0이라면 중지한다.
			if(land == 0) break out;
			//ans를 업데이트한다.
			ans = Math.max(ans, land);
		}
		//답을 출력한다.
		System.out.println(ans);
		//자원을 종료한다.
		in.close();
	}
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int i, int j, int day) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int row = queue.peek()[0];
			int col = queue.poll()[1];
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(!visited[nr][nc] && arr[nr][nc] > day) {
						queue.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
