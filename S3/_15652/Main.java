package S3._15652;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		ans = new StringBuilder();
		combR(0, 1);
		System.out.println(ans);
	}
	static int N, M;
	static int[] selected;
	static StringBuilder ans;
	static void combR(int depth, int start) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				ans.append(selected[i]).append(" ");
			}
			ans.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			selected[depth] = i;
			combR(depth + 1, i);
		}
	}
}
