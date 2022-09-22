package S2._2805;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		int maxLen = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			maxLen = Math.max(maxLen, arr[i]);
		}
		result = 0;
		binaryS(0, maxLen);
		System.out.println(result);
	}
	static int result;
	static void binaryS(int left, int right) {
		int mid = left + (right - left) / 2;
		if(mid == left || mid == right) {
			if(treeCut(right) < M) 
				result = Math.max(result, left);
			else
				result = Math.max(result, right);
			return;
		}
		if(treeCut(mid) < M)
			binaryS(left, mid);
		else
			binaryS(mid, right);
	}
	
	static long treeCut(int h) {
		long sum = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] - h > 0)
				sum += arr[i] - h;
		}
		return sum;
	}
}
