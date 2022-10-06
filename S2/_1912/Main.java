package S2._1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine()); 
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0] = arr[0];
		for (int i = 1; i < dp.length; i++) {
			if(dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + arr[i];
			} else {
				dp[i] = arr[i];
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
