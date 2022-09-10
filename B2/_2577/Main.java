package B2._2577;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1  = sc.nextInt();
		int num2  = sc.nextInt();
		int num3  = sc.nextInt();
		String result = String.valueOf(num1 * num2 * num3);
		int[] oneToTen	= new int[10];
		for(int i = 0; i < result.length(); i++) {
			oneToTen[result.charAt(i) - '0']++;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(oneToTen[i]);
		}
	}
}
