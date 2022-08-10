package S4._2567;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 흰색 도화지
		boolean[][] arr = new boolean[100][100];
		int num = sc.nextInt();
		// 색종이 붙이기
		for (int i = 0; i < num; i++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			for (int l = left; l < left + 10; l++) {
				for (int b = bottom; b < bottom + 10; b++) {
					arr[b][l] = true;
				}
			}
		}
		// 행방향 탐색, 열방향 탐색을 하며 상태가 바뀔때마다 +1 을 해준다.
		// 현재 상태 변수
		boolean flag = false;
		// 결과 저장 변수
		int result = 0;
		// 열방향 탐색
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				//현재 true 라면 false를 만났을때, result에 1을 더해주고 false로 변환
				if(flag && !arr[i][j]) {
					result++;
					flag = !flag;
				}
				//현재 false일때, true를 만나면 result에 1을 더해주고 true로 변환
				else if(!flag && arr[i][j]) {
					result++;
					flag = !flag;
				}
				
			}
			//한 줄이 끝날때, 현재가 true면 result에 1을 더해준다.
			if(flag) result++;
			//한 줄마다 초기화
			flag = false;
		}
		//행방향 탐색도 동일하게 진행
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 100; i++) {
				//현재 true 라면 false를 만났을때, result에 1을 더해주고 false로 변환
				if(flag && !arr[i][j]) {
					result++;
					flag = !flag;
				}
				//현재 false일때, true를 만나면 result에 1을 더해주고 true로 변환
				else if(!flag && arr[i][j]) {
					result++;
					flag = !flag;
				}
			}
			//한 줄이 끝날때, 현재가 true면 result에 1을 더해준다.
			if(flag) result++;
			//한 줄마다 초기화
			flag = false;
		}
		//결과를 출력
		System.out.println(result);
		sc.close();
	} // main
}

//for (int i = 0; i < 100; i++) {
//	for (int j = 0; j < 100; j++) {
//		if (arr[i][j])
//			System.out.print(1);
//		else
//			System.out.print(0);
//	}
//	System.out.println();
//}
//// 시작 지점 찾기
//int startX = 0;
//int startY = 0;
//out: for (int l = 0; l < 100; l++) {
//	for (int b = 0; b < 100; b++) {
//		if (arr[b][l]) {
//			startX = l;
//			startY = b;
//			break out;
//		}
//	}
//}
//// 상우하좌 델타이동
//int[] dx = { 0, 1, 0, -1 };
//int[] dy = { -1, 0, 1, 0 };
//int d = 1;
//// 둘레의 길이
//int result = 2;
//// 이동할 좌표
//int tmpX = startX + dx[d];
//int tmpY = startY + dy[d];
//// 제자리로 돌아올 때까지 반복
//while (tmpX != startX || tmpY != startY) {
//	// 왼쪽 확인 용 인덱스
//	int t = 0;
//	if (d == 0)
//		t = 3;
//	else
//		t = d - 1;
//	// 직진 : 진행방향의 앞쪽이 배열밖이 아니고 true이고 왼쪽이 false 혹은 배열밖일때
//	if (tmpX + dx[d] >= 0 && tmpX + dx[d] <= 99 && tmpY + dy[d] >= 0 && tmpY + dy[d] <= 99
//			&& arr[tmpY + dy[d]][tmpX + dx[d]] && (tmpX + dx[t] < 0 || tmpX + dx[t] > 99 || tmpY + dy[t] < 0
//					|| tmpY + dy[t] > 99 || !arr[tmpY + dy[t]][tmpX + dx[t]])) {
//		result++;
//	}
//	// 좌회전 : 진행방향의 왼쪽이 배열 안쪽이면서 true
//	else if (tmpX + dx[t] >= 0 && tmpX + dx[t] <= 99 && tmpY + dy[t] >= 0 && tmpY + dy[t] <= 99
//			&& arr[tmpY + dy[t]][tmpX + dx[t]]) {
//		if (d == 0)
//			d = 3;
//		else
//			d--;
//	}
//	// 우회전 : 진행방향의 앞쪽이 배열밖이거나 false 일때
//	else if (tmpX + dx[d] < 0 || tmpX + dx[d] > 99 || tmpY + dy[d] < 0 || tmpY + dy[d] > 99
//			|| !arr[tmpY + dy[d]][tmpX + dx[d]]) {
//		result += 2;
//		d = (d + 1) % 4;
//	}
//	tmpX += dx[d];
//	tmpY += dy[d];
//}
//// 결과를 출력
//System.out.println(result);