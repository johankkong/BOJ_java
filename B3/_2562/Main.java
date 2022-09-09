package B3._2562;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		int max = 0;
		int idx = -1;
		for(int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
			if(nums[i] > max) {
				max = nums[i];
				idx = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
