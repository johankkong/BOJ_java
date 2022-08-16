package S2._2615;

import java.util.Scanner;

public class Main {
	static int[][] arr = new int[19][19];
	static boolean flag = false;
	static boolean win(int i, int j) {
		// 현재칸
		int tmp = arr[i][j];
		// 한 지점에서 이길 수 있는 경우의 수는 네가지
		int[] dr = { 0, -1, 1, 1 };
		int[] dc = { 1, 1, 1, 0 };
		// 1. 오른쪽으로 5개
		// 2. 오른쪽 위로 5개
		// 3. 오른쪽 아래로 5개
		// 4. 아래로 5개
		out : for (int d = 0; d < 4; d++) {
			//경계선 안쪽
			if(i + dr[d] * 4 >= 0 && i + dr[d] * 4 < 19 && j + dc[d] * 4 >= 0 && j + dc[d] * 4 < 19) {
				//5개 확인
				for (int k = 1; k < 5; k++) {
					if (tmp != arr[i + dr[d] * k][j + dc[d] * k]) continue out;
				}
			} else continue out;
			//6개째가 안쪽인 경우에만
			if(i + dr[d] * 5 >= 0 && i + dr[d] * 5 < 19 && j + dc[d] * 5 >= 0 && j + dc[d] * 5 < 19) {
				// 6개도 같은 경우 제외
				if (tmp == arr[i + dr[d] * 5][j + dc[d] * 5]) continue out;
			}
			//-1개째가 안쪽인 경우에만
			if(i + dr[d] * -1 >= 0 && i + dr[d] * -1 < 19 && j + dc[d] * -1 >= 0 && j + dc[d] * -1 < 19) {
				// 반대방향이 같은 경우에 제외
				if (tmp == arr[i + dr[d] * -1][j + dc[d] * -1]) continue out;
			}
			// 여기까지 온 경우 오목 완성
			flag = true;
			return true;
		}
		// 4방향 모두 확인했는데 return 안됐으면
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		out : for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				//오목알을 둔 지점에서 true가 나온다면 결과 출력
				if(arr[i][j] != 0 && win(i, j)) {
					System.out.println(arr[i][j]);
					System.out.println((i+1) + " " + (j+1));
					break out;
				}
			}
		}
		//승부가 결정되지 않은 경우
		if(!flag) System.out.println(0);
		sc.close();
	}
}
