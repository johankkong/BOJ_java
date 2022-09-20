package G5._17070;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][][] dp = new int[N][N][3];
		// 각 칸별로 가로, 세로, 대각선 형태로 존재할 수 있는 경우의 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 1)	//벽을 만나는 경우
					dp[i][j] = new int[] {0, 0, 0};
				else if(j == 0)		//맨 왼쪽 줄
					dp[i][j] = new int[] {0, 0, 0};
				else if(i == 0 && j == 1)
					dp[i][j] = new int[] {1, 0, 0};
				else if(i == 0)		//맨 윗줄
					dp[i][j] = new int[] {dp[i][j-1][0], 0, 0};
				else {
					//가로가 될 수 있는 경우는 왼쪽칸에 가로 형태 혹은 대각선 형태
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
					//세로가 될 수 있는 경우는 위쪽칸에 세로 형태 혹은 대각선 형태
					dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
					//위칸 혹은 왼쪽칸이 벽인 경우 대각선이 불가
					if(arr[i-1][j] == 1 || arr[i][j-1] == 1) 
						dp[i][j][2] = 0;
					else
						//대각선이 될 수 있는 경우는 왼쪽 위 칸의 세가지 모두
						dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		//마지막칸에 올 수 있는 경우의 수는 dp의 마지막 칸의 세가지 경우를 모두 더한 것
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}
