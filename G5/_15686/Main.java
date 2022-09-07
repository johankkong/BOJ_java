package G5._15686;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RC { // 좌표를 표현하는 클래스
	int row;
	int col;

	public RC(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int N, M;
	static boolean[] selected; // 요소가 선택됨을 확인할 배열
	static List<RC> list; 
	static int[][] arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N]; // 배열에 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		list = new ArrayList<>(); // 치킨집의 좌표를 저장할 list, 치킨집이 몇개인지 몰라서 list로 했어요
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 2)
					list.add(new RC(i, j)); // 치킨집 위치를 list에 저장
			}
		}
		selected = new boolean[list.size()];
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(ans);
	}

	static void comb(int depth, int start) { // 치킨집 중에서 조합으로 M개를 뽑는다.
		if (depth == M) {
			ans = Math.min(ans, distance());  //조합된 치킨집까지의 거리합을 현재 값과 비교
			return;
		}
		for (int i = start; i < list.size(); i++) {
			selected[i] = true;
			comb(depth + 1, i + 1);
			selected[i] = false;
		}
	}

	static int distance() {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) { // 각 좌표를 돌면서
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) { // 집을 만나면
					int minDistance = Integer.MAX_VALUE;
					for (int k = 0; k < selected.length; k++) {
						if (selected[k]) { // 조합으로 뽑은 치킨집까지의 거리를 각각 구해
							int localDistance = Math.abs(list.get(k).row - i) + Math.abs(list.get(k).col - j);
							minDistance = Math.min(minDistance, localDistance); // 더 작은 것을
						}
					}
					tmp[i][j] = minDistance; // 임시 배열에 저장한다.
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) { // 임시배열의 각 좌표를 돌면서
			for (int j = 0; j < N; j++) {
				sum += tmp[i][j];  //모든 집의 치킨집까지의 거리를 더한다.
			}
		}
		return sum;  //치킨 거리를 반환한다.
	}
}
