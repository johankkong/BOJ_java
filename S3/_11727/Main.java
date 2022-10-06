package S3._11727;

import java.util.Scanner;

public class Main {
	//DP
	//i-1번째 경우의 수
	//i-2번째 겨우의 수 x 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2) %  10007;
		}
		System.out.println(dp[N]);
	}
}
