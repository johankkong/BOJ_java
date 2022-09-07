package B1._1157;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		text = text.toUpperCase();
		int[] arr = new int[26];
		for(int i = 0; i < text.length(); i++) 
			arr[text.charAt(i) - 'A']++;
		int max = 0;
		int idx = 0;
		int tmp = 0;
		for(int i = 0; i < 26; i++) {
			if(max < arr[i]) {
				max = arr[i];
				tmp = 1;
				idx = i;
			} else if(max == arr[i])
				tmp++;
		}
		if(tmp > 1) System.out.println("?");
		else System.out.println((char)(idx + 'A'));
	}
}
