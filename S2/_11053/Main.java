package S2._11053;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[num];  //각 칸에 대한 최대 수열 길이를 저장할 배열 생성
		//수열이 1개라면 최대 수열 길이는 1
		dp[0] = 1;
		//모든칸에 대해 한칸씩 움직이며
		for(int i = 1; i < num; i++) {
			int max = 0;
			//그 이전칸들 중
			for(int j = 0; j < i; j++) {
				//현재칸보다 작은 수를 가진 칸의 최대 수열길이를 구한다.
				if(arr[i] > arr[j]) max = Math.max(max, dp[j]);
			}
			//그 최대 수열길이에 1을 더해 현재 dp에 저장한다.
			dp[i] = max + 1;
		}
		//결과를 출력
		int ans = 0;
		for(int i = 0; i < num; i++) {   //dp배열 중 최대값
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
