package G5._16927;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N][M]; // 배열 생성해서 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		turn(R);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int d;
	//배열 돌리는 메소드
	static void turn(int R) {
		for(int i = 0; i < Math.min(M, N) / 2; i++) {  //각 layer의 좌측 상단 좌표 arr[i][i]
			d = 0;
			int nr = i, nc = i;
			//layer별로 좌측상단부터 시계방향으로 queue에 넣는다.
			Queue<Integer> queue = new LinkedList<>();
			while(queue.size() != 2 * M + 2 * N - 8 * i - 4) {
				queue.offer(arr[nr][nc]);
				if(queue.size() < M - i * 2) //상단
					d = 0;
				else if(queue.size() < M + N - 4 * i - 1) //우측
					d = 1;
				else if(queue.size() < 2 * M + N - 6 * i - 2) //하단
					d = 2;
				else   //좌측
					d = 3;
				nr += dr[d];
				nc += dc[d];
			}
			//queue에 모두 담았으니 이동해야하는 만큼 빼고 넣는다.
			int rot = R % (2 * M + 2 * N - 8 * i - 4);
			for(int j = 0; j < rot; j++) {
				queue.offer(queue.poll());
			}
			//queue에 담긴 순서대로 다시 arr에 넣는다.
			nr = i;
			nc = i;
			while(queue.size() != 0) {
				arr[nr][nc] = queue.poll();
				if(queue.size() > M + 2 * N - 6 * i - 4) //상단
					d = 0;
				else if(queue.size() > M + N - 4 * i - 3) //우측 하단
					d = 1;
				else if(queue.size() > N - 2 * i - 2) //좌측 하단
					d = 2;
				else 
					d = 3;
				nr += dr[d];
				nc += dc[d];
			}
		}
	}
	
}
