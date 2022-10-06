package S2._11084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][M];
		int[] dr = {-1, -1, 0};
		int[] dc = {-1, 0, -1};
		dp[0][0] = arr[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int localMax = -1;
				for (int d = 0; d < 3; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr >= 0 && nc >= 0) {
						localMax = Math.max(localMax, dp[nr][nc]);
					}
				}
				if(localMax != -1) {
					dp[i][j] = localMax + arr[i][j];
				}
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}
