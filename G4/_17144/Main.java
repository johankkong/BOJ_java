package G4._17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Cell[][] arr = new Cell[R][C];
		int rClean = -1;
		int cClean = -1;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = new Cell(Integer.parseInt(st.nextToken()));
				if(arr[i][j].original == -1) {
					rClean = i;
					cClean = j;
				}
			}
		}
		//T초만큼 반복
		for (int t = 0; t < T; t++) {
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			//모든칸에 대해 확산을 실행한다.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(arr[i][j].original > 0) {
						int part = arr[i][j].original / 5;
						int cnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i +dr[d];
							int nc = j + dc[d];
							if(nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc].original != -1) {
								cnt++;
								arr[nr][nc].plus += part;
							}
						}
						arr[i][j].original -= part * cnt;
					}
				}
			}
			//모든 칸의 original과 plus를 합쳐준다.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					arr[i][j].original += arr[i][j].plus;
					arr[i][j].plus = 0;
				}
			}
			//공기청정기 가동시작
			//위쪽 바람
			int r = rClean - 2;
			int c = cClean;
			int d = 0;
			while(r != rClean - 1 || c != cClean) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= rClean || nc < 0 || nc >= C) {
					d++;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				if(arr[nr][nc].original == -1) arr[r][c].original = 0;
				else arr[r][c].original = arr[nr][nc].original;
				r = nr;
				c = nc;
			}
			//아래쪽바람
			dr = new int[] {1, 0, -1, 0};
			dc = new int[] {0, 1, 0, -1};
			r = rClean + 1;
			c = cClean;
			d = 0;
			while(r != rClean || c != cClean) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < rClean || nr >= R || nc < 0 || nc >= C) {
					d++;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				if(arr[nr][nc].original == -1) arr[r][c].original = 0;
				else arr[r][c].original = arr[nr][nc].original;
				r = nr;
				c = nc;
			}
		}
		//결과를 출력
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j].original != -1) ans += arr[i][j].original;
			}
		}
		System.out.println(ans);
	}
	static class Cell {
		int original;
		int plus;
		public Cell(int original) {
			this.original = original;
			this.plus = 0;
		}
		
	}
}
