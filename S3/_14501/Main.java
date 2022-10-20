package S3._14501;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
		}
		int[] dp = new int[N + 1];
		for (int i = N - 1; i >= 0; i--) {
			if(i + arr[i][0] > N) {
				continue;
			}
			dp[i] = dp[i + arr[i][0]] + arr[i][1];
		}
		int ans = -1;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
	}
}
