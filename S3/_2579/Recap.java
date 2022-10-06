package S3._2579;

import java.util.Scanner;

public class Recap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[][] dp = new int[3][N];
		//1칸 뛰어서 도착
		//2칸 뛰어서 도착
		//건너뜀
		dp[0][0] = arr[0];
		dp[1][0] = 0;
		dp[2][0] = 0;
		if(N != 1) {
			dp[0][1] = dp[0][0] + arr[1];
			dp[1][1] = arr[1];
			dp[2][1] = arr[0];
		}
		for (int i = 2; i < N; i++) {
			dp[0][i] = dp[1][i-1] + arr[i];
			dp[1][i] = Math.max(dp[0][i-2], dp[1][i-2]) + arr[i];
			dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
		}
		System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
	}
}
