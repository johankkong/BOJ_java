package G2._17143;

import java.io.*;
import java.util.*;

public class Main {
	static class Shark implements Comparable<Shark> {
		int row;
		int col;
		int vel;
		int dir;
		int size;

		public Shark(int row, int col, int vel, int dir, int size) {
			super();
			this.row = row;
			this.col = col;
			this.vel = vel;
			this.dir = dir;
			this.size = size;
		}

		// 상어가 이동하는 메소드
		public void move() {
			if (this.dir == 1 || this.dir == 2) {
				if (this.dir == 1) {
					int nr = this.row - this.vel;
					// 0보다 작아지면, 방향을 전환
					if (nr < 0) {
						nr *= -1;
						this.dir = 2;
					}
					// 방향을 전환했는데 R보다 크다면 다시 방향 전환
					if (nr >= R) {
						nr = (R - 1) * 2 - nr;
						this.dir = 1;
					}
					this.row = nr;
				} else if (this.dir == 2) {
					int nr = this.row + this.vel;
					// R보다 커지면, 방향을 전환
					if (nr >= R) {
						nr = (R - 1) * 2 - nr;
						this.dir = 1;
					}
					// 0보다 작아지면, 방향을 전환
					if (nr < 0) {
						nr *= -1;
						this.dir = 2;
					}
					this.row = nr;
				}
			} else {
				if (this.dir == 4) {
					int nc = this.col - this.vel;
					// 0보다 작아지면, 방향을 전환
					if (nc < 0) {
						nc *= -1;
						this.dir = 3;
					}
					// 방향을 전환했는데 R보다 크다면 다시 방향 전환
					if (nc >= C) {
						nc = (C - 1) * 2 - nc;
						this.dir = 4;
					}
					this.col = nc;
				} else if (this.dir == 3) {
					int nc = this.col + this.vel;
					// R보다 커지면, 방향을 전환
					if (nc >= C) {
						nc = (C - 1) * 2 - nc;
						this.dir = 4;
					}
					// 0보다 작아지면, 방향을 전환
					if (nc < 0) {
						nc *= -1;
						this.dir = 3;
					}
					this.col = nc;
				}

			}
		}

		@Override
		public int compareTo(Shark o) {
			// 열 행 크기 순으로 정렬
			if (this.col == o.col) {
				if (this.row == o.row) {
					return this.size - o.size;
				}
				return this.row - o.row;
			}
			return this.col - o.col;
		}

		@Override
		public String toString() {
			return "Shark [row=" + row + ", col=" + col + ", vel=" + vel + ", dir=" + dir + ", size=" + size + "]";
		}

	}

	static int R, C, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Shark> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int vel = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			if(dir == 1 || dir == 2) {
				list.add(new Shark(row, col, vel % ((R - 1) * 2), dir, size));
			} 	else {
				list.add(new Shark(row, col, vel % ((C - 1) * 2), dir, size));
			}
		}
		int ans = 0;
		for (int i = 0; i < C; i++) {
			Collections.sort(list);
			// i번째 행의 가장 위 쪽의 상어를 잡는다.
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).col == i) {
					ans += list.get(j).size;
					list.remove(j);
					break;
				}
				if (list.get(j).col > i) {
					break;
				}
			}
//			for (Shark shark : list) {
//				System.out.println(shark);
//			}
//			System.out.println("---");
			// 상어가 이동한다.
			for (int j = 0; j < list.size(); j++) {
				list.get(j).move();
			}
//			for (Shark shark : list) {
//				System.out.println(shark);
//			}
//			System.out.println("---");
			// 동일한 위치에 상어가 있을 경우 가장 큰 상어만 남긴다.
			Collections.sort(list);
			int row = -1;
			int col = -1;
			for (int j = 0; j < list.size(); j++) {
				Shark currShark = list.get(j);
				if (currShark.row == row && currShark.col == col) {
					list.remove(--j);
				} else {
					row = currShark.row;
					col = currShark.col;
				}
			}
//			for (Shark shark : list) {
//				System.out.println(shark);
//			}
//			System.out.println("---");

		}
		// 결과 출력
		System.out.println(ans);
	}
}
