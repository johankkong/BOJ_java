package B4._2439;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <n; i++) {
			sb.append(" ");
		}
		for(int i = n - 1; i >= 0; i--) {
			sb.setCharAt(i, '*');
			System.out.println(sb);
		}
	}
}
