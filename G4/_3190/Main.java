package G4._3190;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			// 사과의 위치를 배열에 표시
			arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		int L = Integer.parseInt(in.readLine());
		int time = 0;
		// 뱀은 2로 표시
		arr[0][0] = 2;
		int[] head = { 0, 0 };
		int[] tail = { 0, 0 };
		int length = 1;
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int d = 0;
		boolean flag = true;
		Queue<String[]> queue = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine());
			queue.add(new String[] { st.nextToken(), st.nextToken() });
		}
		
		Queue<int[]> snake = new LinkedList<>();
		
		game: while (true) {
			if(!queue.isEmpty() && time == Integer.parseInt(queue.peek()[0])) {
				String turn = queue.poll()[1];
				switch (turn) {
				case "D":
					d = (d + 1) % 4;
					break;
				case "L":
					d = (d + 3) % 4;
					break;
				}
			}
			
				
				System.out.println(time);
				for (int[] is : arr) {
					System.out.println(Arrays.toString(is));
				}
				System.out.println("length : " + length);
				System.out.println("head [" + head[0] + ", " + head[1] + "]" );
				System.out.println("tail [" + tail[0] + ", " + tail[1] + "]" );
				System.out.println("----");
				
				
				time++;
				// 1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
				head[0] = head[0] + dr[d];
				head[1] = head[1] + dc[d];
				snake.add(head.clone());
				// 해당 위치가 벽 밖 혹은 자신의 몸인지 판단
				if (head[0] < 0 || head[0] >= N || head[1] < 0 || head[1] >= N || arr[head[0]][head[1]] == 2) {
					flag = false;
					break game;
				}
				// 2. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
				if (arr[head[0]][head[1]] == 1) {
					arr[head[0]][head[1]] = 2;
					length++;
				} else {
					// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
					arr[head[0]][head[1]] = 2;
					arr[tail[0]][tail[1]] = 0;
					tail = snake.poll();
				}

		}
		// 결과 출력
		System.out.println(time);
	}
}
