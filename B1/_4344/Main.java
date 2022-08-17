package B1._4344;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			int[] scores = new int[num];
			int sum = 0;
			for(int i = 0; i < num; i++) {
				scores[i] = sc.nextInt();
				sum += scores[i];
			}
			double avg = sum / (double)num;
			//평균을 넘는 학생 수
			int over = 0;
			for(int i = 0; i < num; i++) {
				if(scores[i] > avg) over++;
			}
			double result = (double)over / num;
			float real = Math.round(result*100000) / 1000.0f;
			System.out.printf("%.3f", real);
			System.out.println("%");
		}
	}

}
