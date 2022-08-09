package S4._10157;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가로 크기
		int c = sc.nextInt();
		// 세로 크기
		int r = sc.nextInt();
		// 관객 번호
		int aud = sc.nextInt();
		// 좌석 배열
		int[][] seat = new int[r][c];
		// 델타이동 배열
		int[] dc = { -1, 0, 1, 0 };
		int[] dr = { 0, 1, 0, -1 };
		int d = 0;
		// 처음 자리
		int x = r - 1;
		int y = 0;
		seat[x][y] = 1;
		for (int i = 1; i < aud; i++) {
			//경계선 안쪽 이면서 앞칸이 0일때
			if ((x + dc[d] >= 0 && x + dc[d] <= r - 1 && y + dr[d] >= 0 && y + dr[d] <= c - 1)
					&& seat[x + dc[d]][y + dr[d]] != 1) {
				x = x + dc[d];
				y = y + dr[d];
				seat[x][y] = 1;
			// 경계선을 만나서나 앞칸이 1일때
			} else {
				//방향 전환
				d = ++d % 4;
				x = x + dc[d];
				y = y + dr[d];
				seat[x][y] = 1;
			}
		}
		//자리 총합보다 큰 수가 올 경우
		if (aud > c * r) {
			System.out.println(0);
		} else {
			System.out.println((y + 1) + " " + (r - x));
		}
	}

}
