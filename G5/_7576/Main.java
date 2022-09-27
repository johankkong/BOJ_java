package G5._7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					queue.offer(new Node(i, j, 0));
					visited[i][j] = true;
				} else if(arr[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}
		cnt = -1;
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(cnt);
	}

	static int cnt;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Node> queue;

	static void bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int r = node.row;
			int c = node.col;
			int day = node.day;
			if(day != cnt) {
				cnt = day;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (arr[nr][nc] != -1 && !visited[nr][nc]) {
						queue.offer(new Node(nr, nc, day + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	static class Node {
		int row;
		int col;
		int day;

		public Node(int row, int col, int day) {
			super();
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
}
