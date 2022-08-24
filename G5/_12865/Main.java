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
		for(int i = 0; i <= total; i++) {  //dp배열을 채워나간다.
			for(int j = 0; j < num; j++) {  //각 물건들에 대해
				if(i - things[j][0] >= 0) {  //물건의 무게를 감당할 수 있는 경우에만
								//해당칸에 들어가 있는 것과 새로운 물건의 가치를 더한 것 중 큰 것을 저장한다.
					dp[i] = Math.max(dp[i], dp[i - things[j][0]] + things[j][1]);
				}
			}
		}
		int max = 0;
		for(int i : dp) max = Math.max(max, i);  //dp 배열 중 최대값
		System.out.println(max);
	}
}