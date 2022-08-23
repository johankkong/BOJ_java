package G5._2294;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int target = sc.nextInt();
		int[] cur = new int[num];
		for(int i = 0; i < num; i++) {
			cur[i] = sc.nextInt();
		}
		//0원부터 가능한 경우의 수를 저장할 dp 배열
		int[] dp = new int[target + 1];
		dp[0] = 1;
		//dp배열을 채운다.
		for(int j = 1; j <= target; j++) {
			//각 칸에 대해 화폐 단위만큼 이전 칸 중에서 가장 적은 dp값에서 1을 더한다.
			int min = target + 1;  //1원으로만 하는 경우의 수 + 1
			for(int i = 0; i < num; i++) {
				if(j == cur[i]) {  //동전 한개로 표현이 가능한 경우
					min = 0;
					break;
				}
				if(j - cur[i] > 0 && dp[j - cur[i]] != 0) {
					min = Math.min(min, dp[j - cur[i]]);
				}
			}
			if(min == target + 1) continue;  //가능한 경우의 수가 없다!
			dp[j] = min + 1;
		}
		//도달하지 못 한 경우 -1
		if(dp[target] == 0) dp[target] = -1;
		//결과를 출력한다.
		System.out.println(dp[target]);
	}
}