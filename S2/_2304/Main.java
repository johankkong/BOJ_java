package S2._2304;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int result = 0; // 최종결과

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ground = new int[1001];
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			ground[sc.nextInt()] = sc.nextInt();
		}
//		calculation(ground, 0);
		int max = 0;
		for(int i = 0; i < ground.length; i++) {
			if(max < ground[i]) max = ground[i];
		}
		int maxLeft = 1001;
		int maxRight = -1;
		for(int i = 0; i < ground.length; i++) {
			if(ground[i] == max) {
				if(i < maxLeft) maxLeft = i;
				if(i > maxRight) maxRight = i;
			}
		}
		if(maxLeft != maxRight) result += (maxRight - maxLeft + 1) * max;
		else result += max;
		int tmp = 0;
		for(int i = 0; i < maxLeft; i++) {
			if(ground[i] > tmp) tmp = ground[i];
			result += tmp;
		}
		tmp = 0;
		for(int i = 1000; i > maxRight; i--) {
			if(ground[i] > tmp) tmp = ground[i];
			result += tmp;
		}
		System.out.println(result);
	}

//	static void calculation(int[] arr, int flag) {
//		//배열의 길이가 1일 경우 리턴
//		if(arr.length <= 1) return;
//		// 현재 배열에서 최댓값 구하기
//		int max = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] > max) {
//				max = arr[i];
//			}
//		}
//		// 최댓값의 인덱스 구하기
//		int maxLeft = 1001;
//		int maxRight = -1;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == max) {
//				maxLeft = Math.min(i, maxLeft);
//				maxRight = Math.max(i, maxRight);
//			}
//		}
//		int[] leftArr = Arrays.copyOf(arr, maxLeft);
//		int[] rightArr = Arrays.copyOfRange(arr, maxRight+1, arr.length);
//		// 가운데 시작
//		if (flag == 0) {
//			// 최댓값이 여러개인 경우
//			if (maxLeft != maxRight) {
//				result += (maxRight - maxLeft + 1) * max;
//			}
//			//하나일 경우
//			else {
//				result += max;
//			}
//			calculation(leftArr, -1);
//			calculation(rightArr, 1);
//		}
//		//오른쪽인 경우
//		else if(flag == 1) {
//			result += (maxRight + 1) * max;
//			if(maxRight == arr.length - 1) return;
//			calculation(rightArr, 1);
//		}
//		//왼쪽인 경우
//		else if(flag == -1) {
//			result += (arr.length - maxLeft) * max; 
//			if(maxLeft == 0) return;
//			calculation(leftArr, -1);
//		}
//	}

}
