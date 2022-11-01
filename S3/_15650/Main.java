package S3._15650;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		sb = new StringBuilder();
		comb(0, 1);
		System.out.println(sb);
	}
	static int[] selected;
	static StringBuilder sb;
	static void comb(int depth, int start) {
		if(depth == M) {
			Arrays.sort(selected);
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			selected[depth] = i;
			comb(depth + 1, i + 1);
		}
	}
}
