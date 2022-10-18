package G4._17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] arr, comm;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comm = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			comm[i][0] = Integer.parseInt(st.nextToken()) - 1;
			comm[i][1] = Integer.parseInt(st.nextToken()) - 1;
			comm[i][2] = Integer.parseInt(st.nextToken());
		}
		order = new int[K];
		visited = new boolean[K];
		ans = Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] order;
	static boolean[] visited;
	static int ans;
	private static void perm(int depth) {
		if(depth == K) {
			int[][] tmp = new int[N][M];
			for (int i = 0; i < N; i++) {
				tmp[i] = arr[i].clone();
			}
			turn(tmp);
			int local = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += tmp[i][j];
				}
				local = Math.min(local, sum);
			}
			ans = Math.min(local, ans);
			return;
		}
		for (int i = 0; i < K; i++) {
			if(!visited[i]) {
				order[depth] = i;
				visited[i] = true;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
	private static void turn(int[][] tmp) {
		for (int o = 0; o < K; o++) {
			int r = comm[order[o]][0];
			int c = comm[order[o]][1];
			int s = comm[order[o]][2];
			for (int i = 1; i <= s; i++) {
				int save = tmp[r-i][c-i];
				int d = 0;
				int nr = r - i + dr[d];
				int nc = c - i + dc[d];
				int cnt = 0;
				while(nr != r - i || nc != c - i) {
					tmp[nr - dr[d]][nc - dc[d]] = tmp[nr][nc];
					cnt++;
					if(cnt == 2 * i) {
						d++;
						cnt = 0;
					}
					nr += dr[d];
					nc += dc[d];
				}
				tmp[r - i][c - i + 1] = save;
			}
		}	
	}
}
