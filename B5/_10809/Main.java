package B5._10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		for (int i = 0; i < text.length(); i++) {
			int tmp = text.charAt(i) - 'a';
			if(alphabet[tmp] == -1) {
				alphabet[tmp] = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]).append(" ");
		}
		System.out.println(sb);
	}
}
