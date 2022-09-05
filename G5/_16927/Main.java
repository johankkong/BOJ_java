package G5._16927;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N][M]; // 배열 생성해서 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		arr = turn(R);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int d;

	static int[][] turn(int R) { // R번 배열돌리는 메소드
		int[][] temp = new int[N][M];
		for (int n = 0; n < Math.min(M, N) / 2; n++) { // 각 겹의 왼쪽위 시작 지점
			for(int i = 0; r < )
			int r = n;
			int c = n;
			d = 0;
			int nr = r;
			int nc = c;
			do {
				if (nr + dr[d] >= 0 && nr + dr[d] < N && nc + dc[d] >= 0 && nc + dc[d] < M
						&& temp[nr + dr[d]][nc + dc[d]] == 0) {
					temp[nr][nc] = arr[nr + dr[d]][nc + dc[d]];
					nr += dr[d];
					nc += dc[d];
				} else {
					d++;
				}
			} while (nr != r + 1 || nc != c);
			temp[nr][nc] = arr[r][c];
		}
		return temp;
	}

}
