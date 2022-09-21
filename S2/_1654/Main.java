package S2._1654;

import java.util.Scanner;

public class Main {
	static int K, N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		arr = new int[K];
		int maxLen = 0;
		for(int i = 0; i < K; i++) {
			arr[i] =  sc.nextInt();
			maxLen = Math.max(arr[i], maxLen);
		}
		result = 0;
		binaryS(1, maxLen);
		System.out.println(result);
	}
	
	static int result;
	//이진 탐색으로 최대 길이를 찾아나간다.
	static void binaryS(int left, int right) {
		int mid = (int)(((long)left + (long)right) / 2);
		if(mid == left || mid == right) {
			if(cutLen(right) < N) result = left;
			else result = right;
			return;
		}
		long midNum = cutLen(mid);
		if(midNum < N) binaryS(left, mid);
		if(midNum >= N) binaryS(mid, right);
	}
	
	//해당 길이로 잘랐을 때 몇개의 랜선이 나오는 지..
	static long cutLen(int len) {
		long cnt = 0;
		for(int line : arr) {
			cnt += line / len;
		}
		return cnt;
	}
}
