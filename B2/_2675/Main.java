package B2._2675;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			String text = sc.next();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < text.length(); i++) {
				for(int j = 0; j < num; j++) {
					sb.append(text.charAt(i));
				}
			}
			System.out.println(sb);
		}
	}
}
