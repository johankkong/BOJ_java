package G4._9663;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		arr = new int[N][N];
		queen(0);
		System.out.println(cnt);
	}
	static int cnt;
	static int[][] arr;
	static void queen(int r) {
		if(r == N) {
			cnt++;
			return;
		}
		for(int c = 0; c < N; c++) {
			if(!able(r, c)) continue;
			arr[r][c] = 1;
			queen(r + 1);
			arr[r][c] = 0;
		}
	}
	private static boolean able(int r, int c) {
		int left = c;
		int right = c;
		for(int row = r - 1; row >= 0; row--) {
			left--;
			right++;
			if(arr[row][c] == 1) return false;
			if(left >= 0 && arr[row][left] == 1) return false;
			if(right < N && arr[row][right] == 1) return false;
		}
		return true;
	}
}
