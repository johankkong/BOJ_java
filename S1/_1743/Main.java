package S1._1743;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int[] pair = new int[2];
			pair[0] = sc.nextInt() - 1;
			pair[1] = sc.nextInt() - 1;
			list.add(pair);
		}
		visited = new boolean[N][M];
		ans = 0;
		for (int i = 0; i < K; i++) {
			if(visited[list.get(i)[0]][list.get(i)[1]] == false) {
				size = 0;
				dfs(list.get(i));
				ans = Math.max(size, ans);
			}
		}
		System.out.println(ans);
	}
	static List<int[]> list;
	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int size;
	private static void dfs(int[] pair) {
		int row = pair[0];
		int col = pair[1];
		size++;
		visited[row][col] = true;
		for(int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				//방문한 적이 없고 list에 해당 좌표가 들어있다면
				if(!visited[nr][nc]) {
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i)[0] == nr && list.get(i)[1] == nc) {
							dfs(new int[] {nr, nc});
							break;
						}
					}
				}
			}
		}
		
	}
	static boolean[][] visited;
	static int ans;
}
