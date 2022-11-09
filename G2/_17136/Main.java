package G2._17136;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		temp = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (sc.nextInt() == 1)
					temp[i][j] = true;
				else
					temp[i][j] = false;
			}
		}
		remain = new int[] { 5, 5, 5, 5, 5 };
		dfs(0, 0, 0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static boolean[][] temp;
	static int[] remain;
	static int ans = Integer.MAX_VALUE;

	static void dfs(int depth, int row, int col) {
		if (row == 9 && col == 10) {
			ans = Math.min(ans, depth);
			return;
		}
		if (depth >= ans) {
			return;
		}
		if (col == 10) {
			dfs(depth, row + 1, 0);
			return;
		}
		if (temp[row][col]) {
			next: for (int len = 5; len > 0; len--) {
				//경계선 안쪽인지
				if (row + len <= 10 && col + len <= 10) {
					//붙일수 있는지
					for (int k = 0; k < len; k++) {
						for (int k2 = 0; k2 < len; k2++) {
							if (!temp[row + k][col + k2])
								continue next;
						}
					}
					if (remain[len - 1] > 0) {
						for (int k = 0; k < len; k++) {
							for (int k2 = 0; k2 < len; k2++) {
								temp[row + k][col + k2] = false;
							}
						}
						remain[len - 1]--;
						dfs(depth + 1, row, col + 1);
						for (int k = 0; k < len; k++) {
							for (int k2 = 0; k2 < len; k2++) {
								temp[row + k][col + k2] = true;
							}
						}
						remain[len - 1]++;
					}
				}
			}
		} else {
			dfs(depth, row, col + 1);
		}
	}

}
