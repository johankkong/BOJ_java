package G4._2580;

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
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 0)   //빈칸인 경우 list에 저장
					blanks.add(new RC(i, j));
			}
		}
		fillSudoku(0);
	}
	private static void fillSudoku(int idx) {
		//전부다 채우면 출력하고 종료;
		if(idx == blanks.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(arr[i][j]);
					if(j != 8) sb.append(" ");
				}
				if(i != 8) sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		//빈칸 list에서 idx번째 빈칸을 가져와
		RC rc = blanks.get(idx);
		//1부터 9까지 넣어본다.
		for(int i = 1; i <= 9; i++) {
			arr[rc.row][rc.col] = i;
			//숫자를 넣고 유효한지 판단한다.
			if(isCorrect(rc.row, rc.col, i))
				//유효하면 다음으로 넘어감
				fillSudoku(idx + 1);
			else //유효하지 않으면 다음 숫자를 넣어봄
				continue;
		}
		//1~9 모두 실패한 경우 0으로 만들어 줌
		arr[rc.row][rc.col] = 0;
	}
	private static boolean isCorrect(int row, int col, int tmp) {
		//행에 자신과 같은 값이 있는 지 확인
		for(int i = 0; i < 9; i++) {
			if(col == i) continue;
			else 
				if(tmp == arr[row][i])
					return false;
		}
		//열에 자신과 같은 값이 있는 지 확인
		for(int i = 0; i < 9; i++) {
			if(row == i) continue;
			else 
				if(tmp == arr[i][col])
					return false;
		}
		//3x3박스에 값은 값이 있는지 확인
		//왼쪽위 좌표
		int ltr = (row / 3) * 3, ltc = (col / 3) * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(ltr + i == row && ltc + j == col)
					continue;
				else
					if(tmp == arr[ltr + i][ltc + j])
						return false;
			}
		}
		//위 조건을 모두 거친다면 유효하다.
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