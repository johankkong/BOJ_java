package G5._2293;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] cur = new int[n];
		for(int i = 0; i < n; i++) {
			cur[i] = sc.nextInt();
		}
		int[] num = new int[n];
		select(cur, num, target, 0);
		System.out.println(result);
	}
	static int result = 0;
	static void select(int[] cur, int[] num, int target, int start) {
		int tmp = 0;
		for(int i = 0; i < cur.length; i++) {
			tmp += cur[i] * num[i];
		}
		if(tmp > target) return;
		if(tmp == target) {
			result++;
			return;
		}
		for(int i = start; i < cur.length; i++) {
			num[i]++;
			select(cur, num, target, i);
			num[i]--;
		}
	}
}
