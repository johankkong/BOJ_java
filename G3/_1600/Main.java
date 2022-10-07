package G3._1600;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dr = { -1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1 };
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		int ans = 0;
		boolean flag = false;
		out: while (!queue.isEmpty()) {
			int tmp = queue.size();

			for (int i = 0; i < tmp; i++) {
				
				int row = queue.peek()[0];
				int col = queue.peek()[1];
				int horse = queue.poll()[2];
				if (row == H - 1 && col == W - 1) {
					flag = true;
					break out;
				}
				for (int d = 0; d < 12; d++) {
					if (d >= 4) {
						if (horse >= K) {
							continue;
						}
					}
					int nr = row + dr[d];
					int nc = col + dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (d >= 4) {
							if (!visited[nr][nc][horse + 1] && arr[nr][nc] == 0) {
								queue.offer(new int[] { nr, nc, horse + 1 });
								visited[nr][nc][horse + 1] = true;
							} 
						} else {
							if (!visited[nr][nc][horse] && arr[nr][nc] == 0) {
								queue.offer(new int[] { nr, nc, horse });
								visited[nr][nc][horse] = true;
							}
						}
					}
				}
			}
			ans++;
		}
		if (flag)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
}
