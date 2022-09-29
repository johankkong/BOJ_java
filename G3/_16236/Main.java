package G3._16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//상어 초기 크기는 2
	//bfs를 통해 자신보다 작은 물고기를 찾아 나가는 것을 반복한다.
	//우선순위가 위 다음 왼쪽이기 때문에, 탐색 순서도 상좌하우 순서로 하는게 중요
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		//상어의 초기 위치
		int row = -1;
		int col = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					row = i;
					col = j;
				}
			}
		}
		time = 0;
		cnt = 0;
		shark(row, col);
		System.out.println(time);
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
			
		}
	}
	//물고기를 먹을 때마다 재귀적으로 호출
	private static void shark(int row, int col) {
		visited = new boolean[N][N];
		//가장 가까운 물고기 위치 찾기
		int[] next = bfs(row, col);
		//더이상 먹을 수 있는 물고기가 없으면 끝
		if(next == null) return;
		//이동거리를 시간에 추가
		time += (Math.abs(row - next[0]) + Math.abs(col - next[1]));
		//원래 자리 0으로 만들기
		arr[row][col] = 0;
		cnt++;
		//물고기 자리를 9로 만들기
		arr[next[0]][next[1]] = 9;
		//물고기 먹은 수가 size와 같으면 몸집이 커져요
		if(cnt == size) {
			cnt = 0;
			size++;
		}
		System.out.println(Arrays.toString(next));
		System.out.println(size);
		System.out.println(time);
		//지금 자리에서 다시 물고기 찾기
		shark(next[0], next[1]);
	}
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	//bfs로 가장 가까운 물고기를 찾자
	private static int[] bfs(int row, int col) {
		int[] pair = {row, col};
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[1];
			}
		});
		queue.add(pair);
		visited[row][col] = true;
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			if(arr[r][c] > 0 && arr[r][c] < size) {
				return new int[] {r, c};
			}
			//4방향 탐색 
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(!visited[nr][nc] && arr[nr][nc] <= size) {
						queue.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return null;
	}
	static int N;
	static int[][] arr;
	static int size = 2;
	static int cnt, time;
	static boolean[][] visited;
	
}
