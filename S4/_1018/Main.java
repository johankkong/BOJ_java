package S4._1018;

import java.util.Scanner;

public class Main {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		arr = new char[r][c];
		for(int i = 0; i < r; i++) {
			String row = sc.next();
			arr[i] = row.toCharArray();
		}
		int result = 64;
		for(int i = 0; i <= r - 8; i++) {
			for(int j = 0; j <= c - 8; j++) {
				int localMin = Math.min(compareB(i, j), compareW(i, j));
				result = Math.min(result, localMin);
			}
		}
		System.out.println(result);
	}
	
	static char[] B = {'B', 'W','B', 'W','B', 'W','B', 'W'};
	static char[] W = {'W','B', 'W','B', 'W','B', 'W', 'B'};
	
	static int compareB(int r, int c) {
		int diff = 0;
		char[] temp;
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) temp = B;
			else temp = W;
			for(int j = 0; j < 8; j++) {
				if(temp[j] != arr[r + i][c + j])
					diff++;
			}
		}
		return diff;
	}
	static int compareW(int r, int c) {
		int diff = 0;
		char[] temp;
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) temp = W;
			else temp = B;
			for(int j = 0; j < 8; j++) {
				if(temp[j] != arr[r + i][c + j])
					diff++;
			}
		}
		return diff;
	}
}
