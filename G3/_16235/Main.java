package G3._16235;

import java.io.*;
import java.util.*;

public class Main {
	static class Tree implements Comparable<Tree>{
		int row;
		int col;
		int age;
		boolean dead;
		public Tree(int row, int col, int age) {
			super();
			this.row = row;
			this.col = col;
			this.age = age;
			this.dead = false;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
		@Override
		public String toString() {
			return "Tree [row=" + row + ", col=" + col + ", age=" + age + ", dead=" + dead + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] nutri = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				nutri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//각 칸마다 List를 만든다.
		List<Tree>[][] trees = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				trees[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			trees[x][y].add(new Tree (x, y, age));
		}
		//각 칸 별로 나이순으로 정렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Collections.sort(trees[i][j]);
			}
		}
		//현재의 양분 상태를 관리할 배열
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5);
		}
		//K년동안 반복
		for (int year = 0; year < K; year++) {
			//봄 : 모든 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가한다.
			//여름 : 양분을 먹을 수 없는 나무가 죽는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int idx = -1;
					for (int j2 = 0; j2 < trees[i][j].size(); j2++) {
						if(map[i][j] >= trees[i][j].get(j2).age) {
							map[i][j] -= trees[i][j].get(j2).age;
							trees[i][j].get(j2).age++;
						} else {
							idx = j2;
							break;
						}
					}
					if(idx != -1) {
						while(trees[i][j].size() != idx) {
							map[i][j] += trees[i][j].get(idx).age / 2; 
							trees[i][j].remove(idx);
						}
					}
				}
			}
			//가을 : 나무가 번식한다.
			int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int len = trees[i][j].size();
					for (int l = 0; l < len; l++) {
						if(trees[i][j].get(l).age % 5 == 0) {
							int r = trees[i][j].get(l).row;
							int c = trees[i][j].get(l).col;
							for (int d = 0; d < 8; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
									trees[nr][nc].add(0, new Tree(nr, nc, 1));
								}
							}
						}
					}
				}
			}
			//겨울 : 양분을 추가한다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += nutri[i][j];
				}
			}
		}
		//결과를 출력
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += trees[i][j].size();
			}
		}
		System.out.println(ans);
	}
}
