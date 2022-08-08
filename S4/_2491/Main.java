package S4._2491;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//수열의 길이 입력
		int n = sc.nextInt();
//수열을 배열로 입력 받는다.
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
//구간의 최대 길이
		int max = 1;
//현재 구간의 길이
		int tmp = 1;
//정방향 탐색
		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] - arr[i] >= 0) {
				tmp++;
			} else {
				if (max < tmp) {
					max = tmp;
				}
				tmp = 1;
			}
		}
		if (max < tmp) {
			max = tmp;
		}
//현재 구간의 길이
		tmp = 1;
//역방향 탐색
		for (int i = 0; i < n - 1; i++) {
			if (arr[n - 2 - i] - arr[n - 1 - i] >= 0) {
				tmp++;
			} else {
				if (max < tmp) {
					max = tmp;
				}
				tmp = 1;
			}
		}
		if (max < tmp) {
			max = tmp;
		}
//결과를 출력
		System.out.println(max);
	}
}

//	Scanner sc = new Scanner(System.in);
//	int n = sc.nextInt();
//	int a = sc.nextInt();
//	int b = 0;
//	int flag = 0;
//	int max = 1;
//	int tmp = 1;
//	for(int i = 1; i < n; i++) {
//		b = sc.nextInt();
//		if(a == b) {
//			tmp++;
//		} else if (a < b) {
//			if(flag == -1) {
//				if(max < tmp) {
//					max = tmp;
//				}
//				tmp = 1;					
//			} else {
//				tmp++;
//			}
//			flag = 1;
//		} else if (a > b) {
//			if(flag == 1) {
//				if(max < tmp) {
//					max = tmp;
//				}
//				tmp = 1;					
//			} else {
//				tmp++;
//			}
//			flag = -1;
//		}
//		a = b;
//	}
//	if(max < tmp) {
//		max = tmp;
//	}
//	System.out.println(max);
//}