package B1._2563;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//검은 색종이 갯수 입력
		int N = sc.nextInt();
		//흰 도화지를 100 x 100 배열로 선언
		int[][] white = new int[100][100];
		//N번 반복하며 해당위치를 1로 바꾼다.
		for(int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			//색종이의 크기만큼 1로 바꿈
			for(int j = r; j < r + 10; j++) {
				for(int k = c; k < c + 10; k++) {
					white[j][k] = 1;
				}
			}
		}
		//100 x 100 배열 전체에서 1의 갯수를 세어 출력한다.
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(white[i][j] == 1)
					sum++;
			}
		}
		//결과를 출력
		System.out.println(sum);
	}

}
