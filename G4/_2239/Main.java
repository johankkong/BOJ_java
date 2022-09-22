package G4._2239;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static List<RC> blanks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9][9];
		blanks = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if (arr[i][j] == 0)
					blanks.add(new RC(i, j));
			}
		}
		fillSudoku(0);
	}

	static void fillSudoku(int depth) {
		if (depth == blanks.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		RC rc = blanks.get(depth);
		for (int num = 1; num <= 9; num++) {
			arr[rc.row][rc.col] = num;
			if (isCorrect(rc.row, rc.col, num)) {
				fillSudoku(depth + 1);
			} else
				continue;
		}
		arr[rc.row][rc.col] = 0;
	}

	static boolean isCorrect(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (i == row)
				continue;
			else if (arr[i][col] == num)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (i == col)
				continue;
			else if (arr[row][i] == num)
				return false;
		}
		int ltr = (row / 3) * 3;
		int ltc = (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(ltr + i == row && ltc + j == col)
					continue;
				else
					if(arr[ltr + i][ltc + j] == num)
						return false;
			}
		}
		return true;
	}
}

class RC {
	int row;
	int col;

	public RC(int row, int col) {
		this.row = row;
		this.col = col;
	}
}