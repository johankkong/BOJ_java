package S2._14889;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		selected = new boolean[N];
		result = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(result);
	}
	static boolean[] selected;
	static int result;
	static void comb(int start, int depth) {
		if(depth == N / 2) {
			int S = 0;
			int L = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(selected[i] && selected[j])
						S += arr[i][j] + arr[j][i];
					else if(!selected[i] && !selected[j])
						L += arr[i][j] + arr[j][i];
				}
			}
			
			result = Math.min(result, Math.abs(S - L));
			return;
		}
		for(int i = start; i < N; i++) {
			selected[i] = true;
			comb(i + 1, depth + 1);
			selected[i] = false;
		}
	}
}
