package G2._19238;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, F;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		taxi = new Driver(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		//승객의 목적지의 위치를 저장할 배열 생성
		int[][] destination = new int[M + 2][4];
		for (int i = 2; i < M + 2; i++) {
			st = new StringTokenizer(in.readLine());
			int psgR = Integer.parseInt(st.nextToken()) - 1;
			int psgC = Integer.parseInt(st.nextToken()) - 1;
			destination[i][0] = psgR;
			destination[i][1] = psgC;
			//승객의 위치 표시
			arr[psgR][psgC] = i;
			//목적지를 저장
			int destR = Integer.parseInt(st.nextToken()) - 1;
			int destC = Integer.parseInt(st.nextToken()) - 1;
			destination[i][2] = destR;
			destination[i][3] = destC;
		}
//		for (int[] is : arr) {
//			System.out.println(Arrays.toString(is));
//		}
		//완료한 승객의 수
		int cnt = 0;
		//승객을 모두 완료하거나 연료가 바닥 날때까지
		out : while(cnt != M && F >= 0) {
			//현재 위치에서 bfs로 승객을 찾는다.
			int curPsg = -1;
			boolean[][] visited = new boolean[N][N];
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] {taxi.row, taxi.col});
			visited[taxi.row][taxi.col] = true;
			int distance = 0;
			//가장 앞 번호를 찾기 위한 PQ
			PriorityQueue<int[]> psg = new PriorityQueue<>(new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] == o2[0]) return o1[1] - o2[1];
					return o1[0] - o2[0];
				}
				
			});
			bfs : while(!queue.isEmpty()) {
				int len = queue.size();
				for (int i = 0; i < len; i++) {
					int[] curr = queue.poll();
					int row = curr[0];
					int col = curr[1];
					if(arr[row][col] >= 2) {
						psg.offer(new int[] {row, col});
						continue;
					}
					for (int d = 0; d < 4; d++) {
						int nr = row + dr[d];
						int nc = col + dc[d];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != 1) {
							if(!visited[nr][nc]) {
								queue.offer(new int[] {nr, nc});
								visited[nr][nc] = true;
							}
						}
					}
				}
				if(!psg.isEmpty()) {
					F -= distance;
					if(F < 0) {
						break out;
					}
					int[] curPsgPos = psg.poll();
					curPsg = arr[curPsgPos[0]][curPsgPos[1]];
					taxi.row = destination[curPsg][0];
					taxi.col = destination[curPsg][1];
					break bfs;
				}
				distance++;
			}
			//승객에게 도달하지 못 했다면
			if(curPsg == -1) {
				break out;
			}
			//현재 자리에서 승객의 목적지를 향해 bfs
			queue = new LinkedList<>();
			visited = new boolean[N][N];
			queue.offer(new int[] {taxi.row, taxi.col});
			visited[taxi.row][taxi.col] = true;
			distance = 0;
			//목적지를 못 찾았을 때를 대비
			boolean flag = false;
			bfs : while(!queue.isEmpty()) {
				int len = queue.size();
				for (int i = 0; i < len; i++) {
					int[] curr = queue.poll();
					int row = curr[0];
					int col = curr[1];
					//목적지에 도달
					if(row == destination[curPsg][2] && col == destination[curPsg][3]) {
						F -= distance;
						if(F < 0) {
							break out;
						}
						//연료 2배 충전
						F += 2 * distance;
						cnt++;
						taxi.row = row;
						taxi.col = col;
						//원래 승객 자리 0으로 만들기
						arr[destination[curPsg][0]][destination[curPsg][1]] = 0;
						flag = true;
						break bfs;
					}
					for (int d = 0; d < 4; d++) {
						int nr = row + dr[d];
						int nc = col + dc[d];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != 1) {
							if(!visited[nr][nc]) {
								queue.offer(new int[] {nr, nc});
								visited[nr][nc] = true;
							}
						}
					}
				}
				distance++;
			}
			//목적지를 찾지 못했다면 끝내야함
			if(!flag) break out;
		}
		int ans = -1;
		if(cnt == M) ans = F;
		System.out.println(ans);
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static Driver taxi;
	static class Driver {
		int row;
		int col;
		public Driver(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
