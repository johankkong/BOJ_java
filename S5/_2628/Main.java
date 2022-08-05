package S5._2628;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가로 세로 입력
		int row = sc.nextInt();
		int col = sc.nextInt();

		// 가로 세로 자르는 숫자 입력
		List<Integer> rowList = new ArrayList<>();
		List<Integer> colList = new ArrayList<>();
		
		//각 List에 0과 최대 길이 추가
		rowList.add(0);
		colList.add(0);
		rowList.add(row);
		colList.add(col);
		
		// 각 숫자를 입력받아 두 List에 추가
		int times = sc.nextInt();
		for (int i = 0; i < times; i++) {
			if (sc.nextInt() == 0) {
				colList.add(sc.nextInt());
			} else {
				rowList.add(sc.nextInt());
			}
		}
		
		//두 List를 오름차순으로 정렬
		Collections.sort(colList);
		Collections.sort(rowList);
		
		//가로와 세로에서 최대 차이를 저장할 변수
		int maxRow = 0;
		int maxCol = 0;
		
		//가로와 세로에서 최대 차이를 찾는다.
		for(int i = 0; i < rowList.size() - 1; i++) {
			int tmp = rowList.get(i+1) - rowList.get(i);
			if (maxRow < tmp) maxRow = tmp;
		}
		for(int i = 0; i < colList.size() - 1; i++) {
			int tmp = colList.get(i+1) - colList.get(i);
			if (maxCol < tmp) maxCol = tmp;
		}
		
		//최대 면적은 maxRow x maxCol
		System.out.println(maxRow * maxCol);
	}

}
