package S4._11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += arr[i] * (N - i);
		}
		System.out.println(ans);
	}
}
