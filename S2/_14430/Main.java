package S2._14430;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 각 칸에 대해 그 칸까지 이동하면서 획득할 수 있는 자원의 수를 저장한다.
		int[][] dp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				//시작지점을 값을 정해준다.
				if(i == 0 && j == 0) dp[i][j] = arr[i][j];
				//위쪽 경계선인 경우, 왼쪽에서 오는 경우만 존재
				else if(i == 0) dp[i][j] = dp[i][j - 1] + arr[i][j];
				//왼쪽 경계선인 경우, 위쪽에서 오는 경우만 존재
				else if(j == 0) dp[i][j] = dp[i - 1][j] + arr[i][j];
				//경계선이 아닌 경우, 왼쪽과 위쪽 중 더 큰 값에 현재 칸을 더해준다.
				else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + arr[i][j];
			}
		}
		//가장 오른쪽 아래의 dp배열 값을 출력한다.
		System.out.println(dp[r - 1][c - 1]);
		sc.close();
	}
}
