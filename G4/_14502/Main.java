package G4._14502;

import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static List<int[]> virus;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		List<int[]> blank = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 0) {
					blank.add(new int[] {i, j});
				}
				else if(arr[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		min = Integer.MAX_VALUE;
		//3개의 벽을 세울 수 있는 모든 경우의 수
		for (int a = 0; a < blank.size() - 2; a++) {
			arr[blank.get(a)[0]][blank.get(a)[1]] = 1;
			for (int b = a + 1; b < blank.size() - 1; b++) {
				arr[blank.get(b)[0]][blank.get(b)[1]] = 1;
				for (int c = b + 1; c < blank.size(); c++) {
					arr[blank.get(c)[0]][blank.get(c)[1]] = 1;
					cnt = 0;
					visited = new boolean[N][M];
					bfs();
					arr[blank.get(c)[0]][blank.get(c)[1]] = 0;
				}
				arr[blank.get(b)[0]][blank.get(b)[1]] = 0;
			}
			arr[blank.get(a)[0]][blank.get(a)[1]] = 0;
		}
		//답
		int ans = blank.size() - min + virus.size() - 3;
		System.out.println(ans);
	}
	 //방문처리 배열
	static boolean[][] visited;
	//최소 바이러스 칸
	static int min;
	//바이러스가 퍼진 칸
	static int cnt;
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		//모든 바이러스 칸을 큐에 넣는다.
		for (int[] is : virus) {
			queue.add(is);
			cnt++;
			visited[is[0]][is[1]] = true;
		}
		while(!queue.isEmpty()) {
			//현재 최솟값을 넘었다면 그만
			if(cnt > min) break;
			int[] tmp = queue.poll();
			int row = tmp[0];
			int col = tmp[1];
			for(int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && arr[nr][nc] == 0) {
					queue.add(new int[] {nr, nc});
					cnt++;
					visited[nr][nc] = true;
				}
			}
		}
		if(cnt < min) min = cnt;
	}
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
}
