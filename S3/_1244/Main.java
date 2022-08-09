package S3._1244;

import java.util.Scanner;

public class Main {

	static int turn(int num) {
		if (num == 0) {
			return 1;
		} else if (num == 1) {
			return 0;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] swi = new int[number];
		for (int i = 0; i < number; i++) {
			swi[i] = sc.nextInt();
		}
		int stu = sc.nextInt();
		for (int i = 0; i < stu; i++) {
			int gen = sc.nextInt();
			int num = sc.nextInt();
			if (gen == 1) {
				for (int j = 1; j <= number / num; j++) {
					swi[num * j - 1] = turn(swi[num * j - 1]);
				}
			} else if (gen == 2) {
				swi[num - 1] = turn(swi[num - 1]);
				int step = 1;
				while(num - step - 1 >= 0 && num + step - 1 < number && swi[num - step - 1] == swi[num + step - 1]) {
					swi[num - step - 1] = turn(swi[num - step - 1]);
					swi[num + step - 1] = turn(swi[num + step - 1]);
					step++;
				}
			}
		}
		for(int i = 0; i < number; i++) {
			if(i % 20 == 19)System.out.println(swi[i]);
			else System.out.print(swi[i] + " ");
			
		}
	}

}
