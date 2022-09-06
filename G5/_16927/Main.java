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
		turn(R);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int d1, d2;

	static void turn(int R) { // R번 배열돌리는 메소드
		int[][] temp = new int[N][M];
		for (int n = 0; n < Math.min(M, N) / 2; n++) { // 각 겹의 왼쪽위 시작 지점
			int smallR = R % (2 * M + 2 * N - 4 * (n + 1)); //각 겹의 갯수로 R을 나눠준다.
			for(int i = 0; i < 2 * M + 2 * N - 4 * (n + 1); i++) { //각 겹의 모든 칸에 대해서
				
			}
		}
	}

}
