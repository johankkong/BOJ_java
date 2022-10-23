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
		int[] dp = new int[N];
		//dp배열을 뒤에서 부터 채워나간다.
		for (int i = N - 1; i >= 0; i--) {
			//해당 날에 시작하여 상담이 끝나는 다음 날
			int day = i + arr[i][0];
			if(day <= N - 1) {
				//그 날 이후로 최대 값을 구한다.
				int local = 0;
				for (int j = day; j < N; j++) {
					local = Math.max(local, dp[j]);
				}
				//해당 날의 상담 비용을 더해 저장한다.
				dp[i] = local + arr[i][1];
			}
			//상담이 끝나는 날이 마지막 날이면 그냥 저장
			else if(day == N){
				dp[i] = arr[i][1];
			}
		}
		int ans = -1;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
	}
}
