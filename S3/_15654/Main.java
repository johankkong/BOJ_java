package S3._15654;

import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		selected = new boolean[N];
		result = new int[M];
		ans = new StringBuilder();
		perm(0);
		System.out.println(ans);
	}
	static boolean[] selected;
	static int[] result;
	static StringBuilder ans;
	static void perm(int depth) {
		if(depth == M) {
			for (int i = 0; i < M; i++) {
				ans.append(result[i]).append(" ");
			}
			ans.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				result[depth] = arr[i];
				perm(depth + 1);
				selected[i] = false;
			}
		}
	}
}
