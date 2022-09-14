package B2._2292;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//1, 2, 8, 20, 38, 62, ...
		if(num == 1) {
			System.out.println(1);
		} else if(num >= 2 && num < 8){
			System.out.println(2);
		} else {
			int sum = 0;
			for(int i = 1; ; i++) {
				sum += i;
				if(sum > (num - 2) / 6) {
					System.out.println(i + 1);
					break;
				}
			}
			
		}
	}
}
