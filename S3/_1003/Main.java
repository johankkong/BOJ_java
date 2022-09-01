package S3._1003;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] dp = new int[41][2];
			//초기값 지정
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			//1이 나오는 횟수와 2가 나오는 횟수를 각각 이전 두 수에서 더해준다.
			for(int i = 2; i <= N; i++) {
				dp[i][0] = dp[i-2][0] + dp[i-1][0];
				dp[i][1] = dp[i-2][1] + dp[i-1][1];
			}
			System.out.print(dp[N][0] + " ");
			System.out.println(dp[N][1]);
		}
	}
}
