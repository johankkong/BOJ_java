package B4._11720;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String numbers = sc.next();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += numbers.charAt(i) - '0';
		}
		System.out.println(ans);
	}
}
