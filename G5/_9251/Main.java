package G5._9251;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text1 = sc.next();
		String text2 = sc.next();
		int[][] lcs = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if(text1.charAt(i - 1) != text2.charAt(j - 1)) {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				} else {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				}
			}
		}
		System.out.println(lcs[text1.length()][text2.length()]);
	}
}
