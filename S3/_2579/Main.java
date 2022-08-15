package S3._2579;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairNum = sc.nextInt();
		int[] stairs = new int[stairNum];
		for (int i = 0; i < stairNum; i++) {
			stairs[i] = sc.nextInt();
		}
		// 계단이 1개일 경우
		if (stairNum == 1) {
			System.out.println(stairs[0]);
			// 아닌 경우에만 dp 적용
		} else {
			// 특정위치까지 도달하는데에 최댓값을 그 이전 계단까지의 최댓값을 통해 구한다.
			// 특정 위치가 가질 수 있는 상태는 총 세 가지
			// 1. 2칸 올라서 도달
			// 2. 1칸 올라서 도달
			// 3. 뛰어넘기
			// 각 칸 별로 이 두가지 상태에 따른 최대값을 저장할 배열을 생성
			int[][] dp = new int[3][stairNum];
			// 초기값을 지정
			// 첫 번째 칸
			dp[0][0] = 0; // 첫번째 칸은 2칸 올라서 도달 x
			dp[1][0] = stairs[0]; // 자기자신
			dp[2][0] = 0; // 첫 건너뛰기는 0
			// 두번째칸
			dp[0][1] = stairs[1]; // 자기자신
			dp[1][1] = dp[1][0] + stairs[1]; // 첫번째 한칸으로 도달 불가
			dp[2][1] = dp[1][0]; // 건너뛰기는 이전 칸의 최대값을 넣기
			// 세번째 칸부터
			for (int i = 2; i < stairNum; i++) {
				// 두칸뛰기 - 이전칸이 빈칸인 경우
				dp[0][i] = dp[2][i - 1] + stairs[i];
				// 한칸뛰기 - 이전칸에서 두칸 뛴 경우에만 가능
				dp[1][i] = dp[0][i - 1] + stairs[i];
				// 건너뛰기 - 이전칸을 뛰어넘은 경우 제외 이전칸의 최대값
				dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
			}
			// 마지막 칸의 최댓값 출력 - 건너뛰는 경우 제외
			System.out.println(Math.max(dp[0][stairNum - 1], dp[1][stairNum - 1]));
		}
		sc.close();
	}
}
