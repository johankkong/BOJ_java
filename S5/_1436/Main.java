package S5._1436;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int num = 666;
		while(true) {
			if(String.valueOf(num).indexOf("666") != -1)
				cnt++;
			if(cnt == N)
				break;
			num++;
		}
		System.out.println(num);
	}
}
