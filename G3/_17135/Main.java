package G3._17135;

import java.util.*;

public class Main {
	static class Enemy implements Comparable<Enemy> {
		int row;
		int col;
		boolean hit;
		public Enemy(int row, int col) {
			this.row = row;
			this.col = col;
			this.hit = false;
		}
		@Override
		public int compareTo(Enemy o) {
			int dis1 = Math.abs(archer[0] - this.row) + Math.abs(archer[1] - this.col);
			int dis2 = Math.abs(archer[0] - o.row) + Math.abs(archer[1] - o.col);
			if(dis1 == dis2) {
				return this.col - o.col;
			}
			return dis1 - dis2;
		}
		@Override
		public String toString() {
			return "Enemy [row=" + row + ", col=" + col + ", hit=" + hit + "]";
		}
		//동일한 객체를 생성해주는 메소드
		public Enemy copy() {
			return new Enemy(this.row, this.col);
		}
		//궁수로 부터의 거리를 반환해주는 메소드
		public int distance() {
			return Math.abs(archer[0] - this.row) + Math.abs(archer[1] - this.col);
		}
	}
	static int[] archer;
	static int N, M, D;
	static List<Enemy> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(sc.nextInt() == 1) {
					list.add(new Enemy(i, j));
				}
			}
		}
		archer = new int[] {N, -1};
		ans = -1;
		
		//궁수를 배치할 수 있는 모든 경우의 수에 대해
		for (int a = 0; a < M - 2; a++) {
			for (int b = a + 1; b < M - 1; b++) {
				for (int c = b + 1; c < M; c++) {
					play(new int[] {a, b, c});
				}
			}
		}
		//결과 출력
		System.out.println(ans);
	}
	private static void play(int[] abc) {
		//적들의 위치를 깊은 복사
		List<Enemy> tmp = new ArrayList<>();
		for (Enemy enemy : list) {
			tmp.add(enemy.copy());
		}
		int cnt = 0;
		//모든 적이 사라질 때까지
		while(!tmp.isEmpty()) {
			//각 궁수가 활을 쏜다.
			for (int i = 0; i < 3; i++) {
				archer[1] = abc[i];
				PriorityQueue<Enemy> pq = new PriorityQueue<>(tmp);
				//가장 가까운 적이 D보다 가깝다면
				if(pq.peek().distance() <= D) {
					pq.poll().hit = true;
				}
			}
			//적군들을 이동시키면서 맞은 적군은 제외한다.
			for (int i = tmp.size() - 1; i >= 0; i--) {
				Enemy e = tmp.get(i);
				if(e.hit) {
					cnt++;
					tmp.remove(e);
				} else {
					if(++e.row >= N) {
						tmp.remove(e);
					}
				}
			}
		}
		//현재 답과 제거한 적 수를 비교한다.
		if(cnt > ans) {
			ans = cnt;
		}
	}
	static int ans;
}
