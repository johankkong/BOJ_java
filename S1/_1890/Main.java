package S1._1890;

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
		// 동일 크기의 dp배열 생성
		long[][] dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//시작 지점
				if(i == 0 && j == 0) dp[i][j] = 1;
				//가장 윗 줄
				else if(i == 0) {
					long cnt = 0; //해당 칸에 도달할 수 있는 방법의 수
					for(int k = 0; k < j; k++) {
						if(k + arr[i][k] == j) cnt += dp[i][k]; //해당 칸에서 뛰어 현재 칸으로 올 수 있는지
					}
					dp[i][j] = cnt;
				}
				//가장 왼쪽 줄
				else if(j == 0) {
					long cnt = 0; //해당 칸에 도달할 수 있는 방법의 수
					for(int k = 0; k < i; k++) {
						if(k + arr[k][j] == i) cnt += dp[k][j];
					}
					dp[i][j] = cnt;
				}
				//나머지
				else {
					long cnt = 0; //해당 칸에 도달할 수 있는 방법의 수
					for(int k = 0; k < i; k++) {  //위에서 올 수 있는 방법
						if(k + arr[k][j] == i) cnt += dp[k][j];
					}
					for(int k = 0; k < j; k++) {  //왼쪽에서 올 수 있는 방법	
						if(k + arr[i][k] == j) cnt += dp[i][k];
					}
					dp[i][j] = cnt;
				}
			}
		}
		//가장 오른쪽 아래의 dp값을 출력
		System.out.println(dp[N-1][N-1]);
	}
}
