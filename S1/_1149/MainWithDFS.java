package S1._1149;

import java.io.*;
import java.util.*;

public class MainWithDFS {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		total = Integer.MAX_VALUE;
		select(0, -1);
		System.out.println(total);
	}
	static int ans, total;
	private static void select(int depth, int color) {
		if(depth == N) {
			total = Math.min(total, ans);
			return;
		}
		//백트래킹
		if(ans > total) {
			return;
		}
		//색 정하기
		for (int i = 0; i < 3; i++) {
			if(color == i) continue;
			ans += arr[depth][i];
			select(depth + 1, i);
			ans -= arr[depth][i];
		}
	}
}
