package B5._10872;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(fact(num));
	}

	static int fact(int num) {
		if(num == 0) return 1;
		else if(num == 1) return 1;
		else return num * fact(num - 1);
	}
}
