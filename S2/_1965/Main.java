package S2._1965;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int boxNum = sc.nextInt();
		//배열로 상자의 크기를 입력 받는다.
		int[] boxes = new int[boxNum];
		for(int i = 0; i < boxNum; i++) {
			boxes[i] = sc.nextInt();
		}
		//dp배열을 생성
		int[] dp = new int[boxNum];
		//첫 박스는 dp값이 1
		dp[0] = 1;
		for(int i = 1; i < boxNum; i++) {
			//현재 박스보다 작은 박스 중에서 가장 많은 박스를 담을 수 있는 박스 + 1
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(boxes[j] < boxes[i]) max = Math.max(max, dp[j]);
				//만약 현재 박스보다 작은 박스가 없다면 > max 가  0
				if(max == 0) dp[i] = 1;
				else dp[i] = max + 1;
			}
		}
		//dp배열 중 최대값을 출력한다.
		int result = 0;
		for(int i = 0; i < boxNum; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

}
