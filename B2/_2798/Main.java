package B2._2798;

import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static boolean[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		selected = new boolean[N];
		result = 0;
		comb(0, 0);
		System.out.println(result);
	}
	static int result;
	private static void comb(int start, int depth) {
		if(depth == 3) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) {
					sum += arr[i];
				}
			}
			if(sum <= M && sum > result) result = sum;
			return;
		}
		for(int i = start; i < N; i++) {
			selected[i] = true;
			comb(i + 1, depth + 1);
			selected[i] = false;
		}
	}
	
}
