package S4._2578;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 빙고판을 2차원 배열로 입력 받는다.
		int[][] bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		// 각 행과 열, 대각선에 몇개의 숫자가 선택되었는지 저장할 배열
		int[] row = new int[5];
		int[] col = new int[5];
		int[] dia = new int[2];

		// 빙고 갯수를 저장
		int bingoNum = 0;
		// 숫자가 불리면 해당 칸을 찾는다.
		out: for (int t = 0; t < 25; t++) {
			int tmp = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (bingo[i][j] == tmp) {
						// 가운데 인지 판별
						if (i == 2 && j == 2) {
							if (++dia[0] == 5)
								bingoNum++;
							if (++dia[1] == 5)
								bingoNum++;
						}
						// 왼쪽 위 대각선인지 판별
						else if (i == j) {
							if (++dia[0] == 5)
								bingoNum++;
						}
						// 오른쪽 위 대각선인지 판별
						else if (i + j == 4) {
							if (++dia[1] == 5)
								bingoNum++;							
						}
						// 행과 열을 각각 1씩 더해주면서 5개 채워지면 bingoNum에도 1을 더함
						if (++col[i] == 5)
							bingoNum++;
						if (++row[j] == 5)
							bingoNum++;
						// bingoNum이 3이상이 되면 해당 tmp를 출력하고 입력받는 것을 중지한다.
						if (bingoNum >= 3) {
							System.out.println(t + 1);
							break out;
						}
						continue out;
					}
				}
			}
		}
		sc.close();
	}
}
