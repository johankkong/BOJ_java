package B1._2309;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		boolean[] selected = new boolean[9];
		sevenHeight(arr, selected, 0, 0, r);
		Arrays.sort(result);
		for(int i : result) {
			System.out.println(i);
		}
	}
	
	static int r = 7;
	static int[] result = new int[r];
	static void sevenHeight(int[] arr, boolean[] selected, int start, int depth, int r) {
		//기저 조건
		if(depth == r) {
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				if(selected[i]) sum += arr[i]; 
			}
			if(sum == 100) {
				int idx = 0;
				for(int i = 0; i < arr.length; i++) {
					if(selected[i]) result[idx++] = arr[i]; 
				}	
			}
			return;
		}
		//유도 파트
		for(int i = start; i < arr.length; i++) {
			selected[i] = true;
			sevenHeight(arr, selected, i+1, depth+1, r);
			selected[i] = false;
		}
	}
}
