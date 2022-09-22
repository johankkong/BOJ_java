package G4._14500;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		result = 0;
		//모든 지점에서 시작하여 최대 합을 갖는 모양을 찾는다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tetris(i, j, 4, 0, 0);
				T(i, j);
			}
		}
		System.out.println(result);
	}
	//좌상우하
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int result;
	static void tetris(int row, int col, int dir, int depth, int sum) {
		//4칸을 모았다면
		if(depth == 4) {
			//현재 result와 비교하여 더 큰 값을 저장
			result = Math.max(result, sum);
			return;
		}
		//첫 시작이라면, 
		if(dir == 4) {
			//네 방향으로 모두 시작한다.
			for(int d = 0; d < 4; d++) {
				// 경계 안쪽인 경우에만,
				if(row + dr[d] >= 0 && row + dr[d] < N && col + dc[d] >= 0 && col + dc[d] < M)
					//다음 칸으로 넘긴다.
					tetris(row + dr[d], col + dc[d], d, depth + 1, arr[row][col]);
			}
		}
		//첫 시작이 아닌 경우
		else {
			//자기 자신이 온 방향을 제외해줘야 한다.
			for(int d = 0; d < 4; d++) {
				if((dir + 2) % 4 == d) continue;
				// 경계 안쪽인 경우에만,
				if(row + dr[d] >= 0 && row + dr[d] < N && col + dc[d] >= 0 && col + dc[d] < M)
					//다음 칸으로 넘긴다.
					tetris(row + dr[d], col + dc[d], d, depth + 1, sum + arr[row][col]);
			}
			
		}
	}
	
	static void T(int row, int col) {
		//꼭짓점 제외
		if((row == 0 || row == N) && (col == 0 || col == M))
			return;
		//네방향 탐색
		int sum;
		for(int i = 0; i < 4; i++) {
			sum = arr[row][col];
			//방향을 제외하고 나머지의 합을 구한다.
			for(int d = 0; d < 4; d++) {
				if(d == i) continue;
				// 경계 안쪽인 경우에만,
				if(row + dr[d] >= 0 && row + dr[d] < N && col + dc[d] >= 0 && col + dc[d] < M)
					sum += arr[row + dr[d]][col + dc[d]];
			}
			//result와 비교한다.
			result = Math.max(result, sum);
		}
	}
}
