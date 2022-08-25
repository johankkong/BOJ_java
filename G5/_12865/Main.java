package G5._12865;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total= sc.nextInt();
		int[][] things = new int[num][2];
		for(int i = 0; i < num; i++) {
			things[i][0] = sc.nextInt();  //무게
			things[i][1] = sc.nextInt();  //가치
		}
		int[] dp = new int[total + 1];  //가능한 무게 크기의 dp배열
		for(int j = 0; j <num; j++) {   //각 물건들에 대해
			for(int i = total; i >= things[j][0]; i--) {  //최대 무게에서 무게를 빼가면서 진행
									// 이 이유는 동일한 물건이 두개 이상 들어가는 것을 방지하기 위함
				//해당칸에 들어가 있는 것과 새로운 물건의 가치를 더한 것 중 큰 것을 저장한다.
				dp[i] = Math.max(dp[i], dp[i - things[j][0]] + things[j][1]);
			}
		}
		int max = 0;
		for(int i : dp) max = Math.max(max, i);  //dp 배열 중 최대값
		System.out.println(max);
	}
}