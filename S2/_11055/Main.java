package S2._11055;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 1];
		//자신보다 작은 값들 중에서 가장 큰 부분 수열을 갖는 곳에 자신을 추가하여 dp배열을 채운다.
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			int frontMax = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					frontMax = Math.max(frontMax, dp[j]);
				}
			}
			dp[i] = frontMax + arr[i];
		}
		//가장 큰 값을 찾는다.
		int ans = -1;
		for (int i = 0; i < dp.length; i++) {
			ans = Math.max(ans, dp[i]);
		}
		//결과 출력
		System.out.println(ans);
	}
}
