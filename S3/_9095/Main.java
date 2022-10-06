package S3._9095;

import java.util.Scanner;

public class Main {
	//DP로 풀이
	//n을 표현하는 방법은
	//1. n-1을 표현하는 방법
	//2. n-2를 표현하는 방법
	//3. n-3을 표현하는 방법
	//세가지를 더하면 된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int num = sc.nextInt();
			int[] dp = new int[num + 1];
			//초기값지정
			dp[0] = 1;
			dp[1] = 1;
			//dp배열 채우기
			for (int i = 2; i < dp.length; i++) {
				if(i - 3 >= 0) dp[i] += dp[i-3];
				if(i - 2 >= 0) dp[i] += dp[i-2];
				if(i - 1 >= 0) dp[i] += dp[i-1];
			}
			//결과 출력하기
			System.out.println(dp[num]);
		}
	}
}
