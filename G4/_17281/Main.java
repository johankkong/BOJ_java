package G4._17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ining;
	static int[][] player;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ining = Integer.parseInt(in.readLine());
		player = new int[ining][9];
		for (int i = 0; i < ining; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		order = new int[9];
		Arrays.fill(order, -1);
		order[3] = 0;
		perm(1);
		System.out.println(ans);
	}

	static int ans;
	static int[] order;

	static void perm(int depth) {
		if(depth == 9) {
			//정해진 타순으로 경기를 진행
			ans = Math.max(ans, game());
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(order[i] == -1) {
				order[i] = depth;
				perm(depth + 1);
				order[i] = -1;
			}
		}
	}

	private static int game() {
		int curr = 0;
		int hitter = 0;
		int score = 0;
		while(curr < ining) {
			int out = 0;
			boolean[] base = new boolean[3];
			while(out < 3) {
				int hit = player[curr][order[hitter]];
				switch(hit) {
				case 0:
					out++;
					break;
				case 1:
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						base[2] = true;
						base[1] = false;
					}
					if(base[0]) {
						base[1] = true;
						base[0] = false;
					}
					base[0] = true;
					break;
				case 2:
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						score++;;
						base[1] = false;
					}
					if(base[0]) {
						base[2] = true;
						base[0] = false;
					}
					base[1] = true;
					break;
				case 3:
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						score++;;
						base[1] = false;
					}
					if(base[0]) {
						score++;;
						base[0] = false;
					}
					base[2] = true;
					break;
				case 4:
					if(base[2]) {
						score++;
						base[2] = false;
					}
					if(base[1]) {
						score++;;
						base[1] = false;
					}
					if(base[0]) {
						score++;;
						base[0] = false;
					}
					score++;
					break;
				}
				if(hitter == 8) hitter = 0;
				else hitter++;
			}
			curr++;
		}
		return score;
	}
}
