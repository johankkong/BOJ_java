package G1._17472;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// DFS를 통해 각 섬을 묶고 번호 메기기
	// 가로 세로로 탐색하면서 다리 건설이 가능한 지 확인하고
	// 각 섬을 vertex로 가능한 다리를 edge로 기록한다.
	// 해당 그래프에서 크루스칼 또는 프림 알고리즘을 통해 최소 다리 길이를 출력한다.
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int num;
	static int[][] adjArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[N][M];
		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					island(i, j);
					num++;
				}
			}
		}
		// 섬에 번호를 매겼다.
		// 이제 가로 세로로 다리를 지을 수 있다면 짓는다.
		// 현재 섬의 갯수 num - 1;
		adjArr = new int[num][num];
		// 가로로 지을 수 있는 다리
		for (int i = 0; i < N; i++) {
			int len = 0;
			int tmp = 0;
			for (int j = 0; j < M; j++) {
				if (tmp == 0 && arr[i][j] != 0) {
					tmp = arr[i][j];
					len = 0;
				} else if (arr[i][j] == 0) {
					len++;
				} else if (tmp == arr[i][j]) {
					len = 0;
				} else if (tmp != arr[i][j]) {
					if (len != 1) {
						if (adjArr[tmp][arr[i][j]] == 0) {
							adjArr[tmp][arr[i][j]] = len;
							adjArr[arr[i][j]][tmp] = len;
						} else {
							adjArr[tmp][arr[i][j]] = Math.min(len, adjArr[tmp][arr[i][j]]);
							adjArr[arr[i][j]][tmp] = Math.min(len, adjArr[arr[i][j]][tmp]);
						}
					}
					tmp = arr[i][j];
					len = 0;
				}
			}
		}
		// 세로로 지을 수 있는 다리
		for (int j = 0; j < M; j++) {
			int len = 0;
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				if (tmp == 0 && arr[i][j] != 0) {
					tmp = arr[i][j];
					len = 0;
				} else if (arr[i][j] == 0) {
					len++;
				} else if (tmp == arr[i][j]) {
					len = 0;
				} else if (tmp != arr[i][j]) {
					if (len != 1) {
						if (adjArr[tmp][arr[i][j]] == 0) {
							adjArr[tmp][arr[i][j]] = len;
							adjArr[arr[i][j]][tmp] = len;
						} else {
							adjArr[tmp][arr[i][j]] = Math.min(len, adjArr[tmp][arr[i][j]]);
							adjArr[arr[i][j]][tmp] = Math.min(len, adjArr[arr[i][j]][tmp]);
						}
					}
					tmp = arr[i][j];
					len = 0;
				}
			}
		}
		// 프림 알고리즘으로 가장 작은 가중치의 MST를 찾는다.
		int INF = Integer.MAX_VALUE;
		int[] prim = new int[num];
		Arrays.fill(prim, INF);
		prim[1] = 0;
		int ans = 0;
		boolean[] visitedPrim = new boolean[num];
		visitedPrim[0] = true;
		for (int v = 1; v < num; v++) {
			// prim 배열에서 가장 작은 것 찾기
			int minPrim = INF;
			int idx = -1;
			for (int i = 0; i < prim.length; i++) {
				if (!visitedPrim[i] && minPrim > prim[i]) {
					minPrim = prim[i];
					idx = i;
				}
			}
			if(idx == -1) break;
			ans += minPrim;
			visitedPrim[idx] = true;
			// 갱신하기
			for (int i = 1; i < num; i++) {
				if (!visitedPrim[i] && adjArr[idx][i] != 0) {
					prim[i] = Math.min(prim[i], adjArr[idx][i]);
				}
			}
		}
		// 연결되지 않은 섬이 있는지 확인
		boolean flag = true;
		for (int i = 1; i < prim.length; i++) {
			if (prim[i] == INF)
				flag = false;
		}
		if (flag)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void island(int i, int j) {
		arr[i][j] = num;
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (arr[nr][nc] == 1 && !visited[nr][nc]) {
					island(nr, nc);
				}
			}
		}
	}
}
