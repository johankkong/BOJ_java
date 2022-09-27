package S2._4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = in.readLine();
		while(!firstLine.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(firstLine);
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N][M];
			int cnt = 0;
			//모든 칸에 대해서 bfs를 실행
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			//결과 출력
			System.out.println(cnt);
			//다음 줄 입력
			firstLine = in.readLine();
		}
		//자원 종료
		in.close();
	}
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
	private static void bfs(int i, int j) {
		Queue<RC> queue = new LinkedList<>();
		//시작 정점을 넣는다.
		queue.offer(new RC(i, j));
		//넣으면서 방문처리
		visited[i][j] = true;
		//queue가 빌 때까지 반복
		while(!queue.isEmpty()) {
			//queue에서 하나를 뽑는다.
			RC rc = queue.poll();
			int r = rc.row;
			int c = rc.col;
			//8방향에 대해 visited가 false이면서 1인 곳을 찾는다.
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				//경계선 안쪽
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(arr[nr][nc] == 1 && !visited[nr][nc]) {
						queue.offer(new RC(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	static class RC {
		int row;
		int col;
		public RC(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
