package S1._16926;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M; // 행과 열 크기
	static int R; // 회전하는 횟수
	static int[][] arr; // 회전시킬 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] tmp = new int[N][M];
		for (int i = 0; i < R; i++) {
			arr = turn();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int d = 0;

	// 배열 돌리는 메소드
	static int[][] turn() {
		d = 0;
		int[][] tmp = new int[N][M];
		int r = 0, c = 0;
		for (int i = 0; i < N * M - 1; i++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || tmp[nr][nc] != 0) {
				if (d == 3)
					d = 0;
				else
					d++;
			}
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && tmp[nr][nc] != 0 && d == 0)
				tmp[r][c] = arr[r - 1][c];
			else {
				switch (d) {
				case 0:
					tmp[r][c] = arr[r][c + 1];
					break;
				case 1:
					tmp[r][c] = arr[r + 1][c];
					break;
				case 2:
					tmp[r][c] = arr[r][c - 1];
					break;
				case 3:
					tmp[r][c] = arr[r - 1][c];
					break;
				}
			}
			r += dr[d];
			c += dc[d];
		}
		tmp[r][c] = arr[r - 1][c];
		return tmp;
	}
}
