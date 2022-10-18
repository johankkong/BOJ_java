package G5._16234;

import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while(true) {
		//번호를 메길 새로운 배열
		number = new int[N][N];
		cnt = 1;
		//각 그룹의 합을 저장할 배열
		sum = new int[2501][2];
		//bfs로 국경선을 연다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(number[i][j] == 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		//열린 국경선이 없으면 멈춘다.
		if(arr[N-1][N-1] == sum[N*N][0]) break;
		//열린 국경선으로 인구이동을 한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sum[number[i][j]][0] / sum[number[i][j]][1];
			}
		}
		//날짜를 추가한다.
		ans++;
		}
		
		System.out.println(ans);
	}
	static int[][] number;
	static int cnt;
	static int[][] sum;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		number[i][j] = cnt;
		sum[cnt][0] += arr[i][j];
		sum[cnt][1]++;
		while(!queue.isEmpty()) {
			int row = queue.peek()[0];
			int col = queue.poll()[1];
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(number[nr][nc] == 0) {
						int value = Math.abs(arr[row][col] - arr[nr][nc]);
						if(value >= L && value <= R) {
							queue.offer(new int[] {nr, nc});
							number[nr][nc] = cnt;
							sum[cnt][0] += arr[nr][nc];
							sum[cnt][1]++;
						}
					}
				}
			}
		}
	}
}
