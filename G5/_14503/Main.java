package G5._14503;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 북동남서
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		// 청소 칸 세기
		int cnt = 0;
		loop: do {
			// 1. 현재 위치를 청소한다.
			if(arr[r][c] == 0) {
				arr[r][c] = 2;
				cnt++;
			}
			// 2. 왼쪽 방향부터 차례대로 탐색을 진행한다.
			for (int i = 1; i <= 4; i++) {
				// 왼쪽으로 방향 돌리기
				if (d - 1 < 0)
					d = 4 + d - 1;
				else
					d = d - 1;
				// 자신의 앞쪽이 청소가 되어있지 않다면
				if (arr[r + dr[d]][c + dc[d]] == 0) {
					// 앞으로 이동하고 다시 반복
					r = r + dr[d];
					c = c + dc[d];
					continue loop;
				}
			}
			// 4방향을 다 돌았는데 청소가 다 되어있다면
			// 뒤가 벽인지 판단
			// 벽이면 청소를 끝냄
			if (arr[r - dr[d]][c - dc[d]] == 1) {
				break loop;
			//벽이 아니면
			} else {
				//후진하여 다시 청소
				r = r - dr[d];
				c = c - dc[d];
			}
		} while (true);
		//결과 출력
		System.out.println(cnt);
		sc.close();
	}
}
