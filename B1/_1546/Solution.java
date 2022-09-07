package B1._1546;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double[] scores = new double[num];
		double maxScore = 0;
		for(int i = 0; i < num; i++) {
			scores[i] = sc.nextInt();
			maxScore = Math.max(scores[i], maxScore);
		}
		double sum = 0;
		for(int i = 0; i < num; i++) {
			scores[i] = (scores[i] / (double)maxScore) * 100;
			sum += scores[i];
		}
		System.out.println(sum / num);
	}
}
