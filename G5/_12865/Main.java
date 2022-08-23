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
		for(int i = 0; i < num; i++) {  //무게 별로 dp를 채워나간다.
			for(int j = things[i][0]; j <= total; j++) {
				//현재 무게에 채워져 있는 가치와 이번 무게를 더했을 때의 가치를 비교하여 더 큰 것을 넣는다.
				dp[j] = Math.max(dp[j], dp[j - things[i][0]] + things[i][1]); 
			}
		}
		int max = 0;
		for(int i : dp) max = Math.max(max, i);  //dp 배열 중 최대값
		System.out.println(max);
	}
}
