package G3._2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		//벽을 부순것과 안 부순 경우를 나누어 방문처리
		boolean[][][] visited = new boolean[2][N][M];
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int ans = Integer.MAX_VALUE;
		//bfs시작
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int punch = tmp[2];
			int step = tmp[3];
			if(r == N - 1 && c == M - 1) {
				ans = Math.min(ans, step);
			}
			//네 방향에 대해
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(arr[nr][nc] == '0' && !visited[punch][nr][nc]) {
						queue.add(new int[] {nr, nc, punch, step + 1});
						visited[punch][nr][nc] = true;
					} else if(punch == 0 && !visited[1][nr][nc] && arr[nr][nc] == '1') {
						queue.add(new int[] {nr, nc, 1, step + 1});
						visited[1][nr][nc] = true;
					}
				}
			}
		}
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
}
