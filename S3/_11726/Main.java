package S3._11726;

import java.util.Scanner;

public class Main {
	//n길이를 만드는 것은
	//n-1길이에 세로로 한칸 붙이는 것
	//n-2길이에 가로로 두칸 붙이는 것
	//두 가지 경우의 수를 더하면 된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007 ;
		}
		System.out.println(dp[N]);
	}
}
