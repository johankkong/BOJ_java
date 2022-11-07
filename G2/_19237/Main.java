package G2._19237;

import java.io.*;
import java.util.*;

public class Main {
	static class Shark implements Comparable<Shark> {
		int number;
		int row;
		int col;
		int dir;
		public Shark(int number, int row, int col) {
			super();
			this.number = number;
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "Shark [number=" + number + ", row=" + row + ", col=" + col + ", dir=" + dir + "]";
		}
		@Override
		public int compareTo(Shark s) {
			if(this.row == s.row && this.col == s.col) return s.number - this.number;
			if(this.row == s.row) return this.col - s.col;
			return this.row - s.row;
		}
	}
	static class Smell {
		int number;
		int duration;
		public Smell(int number, int duration) {
			super();
			this.number = number;
			this.duration = duration;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Shark> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num != 0) {
					list.add(new Shark(num, i, j));
				}
			}
		}
		int[] sharksDir = new int[M];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			sharksDir[i] = Integer.parseInt(st.nextToken());
		}
		//각 상어에 방향을 부여한다.
		for (Shark s : list) {
			s.dir = sharksDir[s.number - 1];
		}
		//1234 상하좌우
		int[] dr = {0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, -1, 1};
		//상어들의 방향 우선순위를 저장한다. 상어번호 / 현재방향 / 우선순위
		int[][][] prior = new int[M][4][4];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(in.readLine());
				for (int j2 = 0; j2 < 4; j2++) {
					prior[i][j][j2] = Integer.parseInt(st.nextToken());
				}
			}
		}
		//상어들의 냄새를 저장하는 배열
		Smell[][] map = new Smell[N][N];
		int time = 0;
		while(time < 1000) {
			//상어가 한마리만 남으면 끝내기
			if(list.size() == 1) break;
			//모든 상어가 자신의 위치에 냄새를 뿌린다.
			for (Shark s : list) {
				map[s.row][s.col] = new Smell(s.number, K); 
			}
			for (Shark s : list) {
				//상어 이동
				int d = -1;
				//먼저 우선순위 순서대로 빈칸 찾기
				for (int i = 0; i < 4; i++) {
					int cur = prior[s.number - 1][s.dir - 1][i];
					int nr = s.row + dr[cur];
					int nc = s.col + dc[cur];
					if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == null) {
						d = cur;
						s.row = nr;
						s.col = nc;
						s.dir = d;
						break;
					}
				}
				//빈칸을 못 찾았다면 자신의 냄새가 있는 칸을 찾기
				if(d == -1) {
					for (int i = 0; i < 4; i++) {
						int cur = prior[s.number - 1][s.dir - 1][i];
						int nr = s.row + dr[cur];
						int nc = s.col + dc[cur];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != null && map[nr][nc].number == s.number) {
							d = cur;
							s.row = nr;
							s.col = nc;
							s.dir = d;
							break;
						}
					}
				}
			}
			//이동을 완료하였으니 시간을 늘리고
			time++;
			//각 냄새의 지속시간을 줄인다.
			for (int i = 0; i < N; i++) {
				for (int l = 0; l < N; l++) {
					if(map[i][l] != null) {
						if(--map[i][l].duration == 0) {
							map[i][l] = null;
						}
					}
				}
			}
			//같은 칸의 상어를 없애기 위해 정렬한다.
			Collections.sort(list);
			//뒤에서부터 탐색하면서 같은 칸에 있는 상어를 없앤다.
			int row = -1;
			int col = -1;
			for (int i = list.size() - 1; i >= 0; i--) {
				Shark s = list.get(i);
				if(row == -1) {
					row = s.row;
					col = s.col;
				} else {
					if(row == s.row && col == s.col) {
						list.remove(i);
					} else {
						row = s.row;
						col = s.col;
					}
				}
			}
		}
		//천번 완료했는데 상어가 두마리 이상이면 -1
		int ans = -1;
		if(list.size() == 1) ans = time;
		System.out.println(ans);
	}
}
