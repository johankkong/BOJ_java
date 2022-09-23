package S5._1676;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int two = 0;
		int five = 0;
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) {
				int tmp = i;
				while(tmp % 2 == 0) {
					tmp /= 2;
					two++;
				}
			}
			if(i % 5 == 0) {
				int tmp = i;
				while(tmp % 5 == 0) {
					tmp /= 5;
					five++;
				}
			}
		}
		System.out.println(Math.min(two, five));
	}
}
