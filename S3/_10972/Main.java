package S3._10972;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//topIdx찾기
		int topIdx = 0;
		for(int i = arr.length - 1; i > 0; i--) {
			if(arr[i - 1] < arr[i]) {
				topIdx = i;
				break;
			}
		}
		if(topIdx == 0) {
			System.out.println(-1);
			return;
		}
		
		//낭떠러지 찾기
		int cliffIdx = topIdx - 1;
		
		//뒤에서 부터 낭떠러지 보다 큰 수 찾기
		int switchIdx = -1;
		for(int i = arr.length - 1; i > cliffIdx; i--) {
			if(arr[cliffIdx] < arr[i]) {
				switchIdx = i;
				break;
			}
		}
		
		//숫자 교환하기
		int temp = arr[switchIdx];
		arr[switchIdx] = arr[cliffIdx];
		arr[cliffIdx] = temp;
		
		//오른쪽부터 꼭대기까지 순서바꾸기
		int rightIdx = arr.length - 1;
		int leftIdx = topIdx;
		 while(leftIdx < rightIdx) {
			 temp = arr[leftIdx];
			 arr[leftIdx] = arr[rightIdx];
			 arr[rightIdx] = temp;
			 rightIdx--;
			 leftIdx++;
		 }
		 
		 //출력하기
		 StringBuilder sb = new StringBuilder();
		 for(int c : arr)
			 sb.append(c).append(" ");
		System.out.println(sb);
	}
}
