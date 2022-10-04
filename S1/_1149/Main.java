package S1._1149;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] dp = new int[N][3];
		StringTokenizer st = new StringTokenizer(in.readLine());
		//dp 초기값 지정
		for (int i = 0; i < 3; i++) dp[0][i] = Integer.parseInt(st.nextToken());
		//다음칸부터 채워나간다.
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				//이전 칸에서 현재 칠하려는 색을 제외하고 더 작은 값을 구한다.
				int front = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
				//현재 집을 칠하는 비용을 더해준다.
				dp[i][j] = front + Integer.parseInt(st.nextToken());
			}
		}
		//마지막 집을 칠하고 가장 적은 비용을 출력한다.
		int ans = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		System.out.println(ans);
	}
}
