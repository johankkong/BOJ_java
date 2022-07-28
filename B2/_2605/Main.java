package B2._2605;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N명 입력
		int N = sc.nextInt();

		// 정수 List 객체 생성
		List<Integer> students = new ArrayList<>();

		// 차례로 입력받은 수에 따라 알맞은 위치에 add한다.
		for (int i = 1; i <= N; i++) {
			int times = sc.nextInt();
			students.add(students.size() - times, i);
		}

		// 순서대로 출력한다.
		for (int i = 0; i < N; i++) {
			System.out.print(students.get(i) + " ");
		}
	}

}
