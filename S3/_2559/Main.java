package S3._2559;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int len = sc.nextInt();
		// 매일 온도를 저장할 배열
		int[] tmps = new int[day];
		for (int i = 0; i < day; i++) {
			tmps[i] = sc.nextInt();
		}
		// 온도 배열을 len만큼 확인하며 max보다 큰 경우 max에 저장
		int max = 0;
		for (int i = 0; i <= day - len; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) {
				sum += tmps[i+j];
			}
			if(i == 0 || max <= sum) max = sum; //모든 합이 0보다 작을 수 있기때문에 첫 합산을 max에 넣어준다.
		}
		//결과를 출력
		System.out.println(max);
		sc.close();
	}

}
