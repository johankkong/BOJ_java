package G3._16236;

import java.io.*;
import java.util.*;

public class Main {
	// 상어 초기 크기는 2
	// bfs를 통해 자신보다 작은 물고기를 찾아 나가는 것을 반복한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		// 상어의 초기 위치
		int row = -1;
		int col = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					row = i;
					col = j;
				}
			}
		}
		time = 0;
		cnt = 0;
		while(!(row == -1 && col == -1)) {
			visited = new boolean[N][N];
			distance = 0;
			// 가장 가까운 물고기 위치 찾기
			int[] next = bfs(row, col);
			// 더이상 먹을 수 있는 물고기가 없으면 끝
			if (next[0] == -1)
				break;
			// 이동거리를 시간에 추가
			time += next[2];
			// 원래 자리 0으로 만들기
			arr[row][col] = 0;
			cnt++;
			// 물고기 자리를 9로 만들기
			arr[next[0]][next[1]] = 9;
			// 물고기 먹은 수가 size와 같으면 몸집이 커져요
			if (cnt == size) {
				cnt = 0;
				if(size < 7) size++;
			}
//			for (int[] i : arr) {
//				System.out.println(Arrays.toString(i));
//			}
//			System.out.println("---");
			// 지금 자리에서 다시 물고기 찾기
			row = next[0];
			col = next[1];
		}
		System.out.println(time);
	}

	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static int distance;
	// bfs로 가장 가까운 물고기를 찾자
	private static int[] bfs(int row, int col) {
		int[] pair = { row, col };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(pair);
		visited[row][col] = true;
		//먹을 수 있는 물고기의 List
		PriorityQueue<int[]> canEat = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
				return o1[2] - o2[2];
			}
		});
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				if (arr[r][c] > 0 && arr[r][c] < size) {
					canEat.add(new int[] {r, c, distance});
					continue;
				}
				// 4방향 탐색
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (!visited[nr][nc] && arr[nr][nc] <= size) {
							queue.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
				}
			}
			//거리를 늘려준다.
			distance++;
		}
		if(canEat.isEmpty()) return new int[] {-1, -1, -1};
		return canEat.poll();
	}

	static int N;
	static int[][] arr;
	static int size = 2;
	static int cnt, time;
	static boolean[][] visited;

}
