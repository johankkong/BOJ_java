package S2._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			int warm = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]) {
						grouping(i, j);
						warm++;
					}
				}
			}
			System.out.println(warm);
		}
	}
	static int N, M;
	static boolean[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void grouping(int i, int j) {
		arr[i][j] = false;
		for (int d = 0; d < 4; d++) {
			if(i + dr[d] >= 0 && i + dr[d] < M && j + dc[d] >= 0 && j + dc[d] < N && arr[i + dr[d]][j + dc[d]])
				grouping(i + dr[d], j + dc[d]);
		}
	}
}
