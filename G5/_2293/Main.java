package G5._2293;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int target = sc.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		//dp배열 생성
		int[] dp = new int[target + 1];
		//초기값 설정
		dp[0] = 1;
		//작은 단위부터 표현할 수 있는 방식을 모두 넣고
		//그 뒤에 큰 단위의 화폐 단위를 추가하면 중복을 제거할 수 있다.
		for(int i = 0; i < num; i++) {
			for(int j = arr[i]; j <= target; j++) {
				dp[j] += dp[j - arr[i]];  //현재의 화폐 단위로 현재칸에 도달할 수 있는 방법을 더해준다.
			}
		}
		//결과 출력
		System.out.println(dp[target]);
	}
}
