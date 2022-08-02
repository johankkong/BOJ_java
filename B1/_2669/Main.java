package B1._2669;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 각 좌표는 1이상 100이하
		int[][] arr = new int[100][100];
		// 4줄 입력 받기
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			//직사각형 면적 1로 채우기
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					arr[x][y] = 1;
				}
			}
		}
		//arr 배열에서 1의 갯수세서 출력하기
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] == 1)
					cnt++;
			}
		}
		//결과 출력
		System.out.println(cnt);
	}
}
