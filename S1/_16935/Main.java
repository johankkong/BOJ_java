package S1._16935;

import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int num = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < num; i++) {
			switch (sc.nextInt()) {
			case 1:
				arr = one(arr);
				break;
			case 2:
				arr = two(arr);
				break;
			case 3:
				arr = three(arr);
				break;
			case 4:
				arr = four(arr);
				break;
			case 5:
				arr = five(arr);
				break;
			case 6:
				arr = six(arr);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] one(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[N - 1 - i][j];
			}
		}
		return tmp;
	}
	
	static int[][] two(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[i][M - 1 - j];
			}
		}
		return tmp;
	}
	
	static int[][] three(int[][] arr) {
		int[][] tmp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[N - 1 - j][i];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		return tmp;
	}

	static int[][] four(int[][] arr) {
		int[][] tmp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[j][M - 1 - i];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		return tmp;
	}
	
	static int[][] five(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i += N / 2) {
			for (int j = 0; j < M; j += M / 2) {
				for(int r = 0; r < N / 2; r++) {
					for(int c = 0; c < M / 2; c++) {
						int tmpi;
						int tmpj;
						if(j == 0) tmpi = N / 2;
						else tmpi = 0;
						if(i == 0) tmpj = 0;
						else tmpj = M / 2;
						tmp[i + r][j + c] = arr[tmpi + r][tmpj + c];
					}
				}
			}
		} 
		return tmp;
	}
	static int[][] six(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i += N / 2) {
			for (int j = 0; j < M; j += M / 2) {
				for(int r = 0; r < N / 2; r++) {
					for(int c = 0; c < M / 2; c++) {
						int tmpi;
						int tmpj;
						if(j == 0) tmpi = 0;
						else tmpi = N / 2;
						if(i == 0) tmpj = M / 2;
						else tmpj = 0;
						tmp[i + r][j + c] = arr[tmpi + r][tmpj + c];
					}
				}
			}
		}
		return tmp;
	}
}
