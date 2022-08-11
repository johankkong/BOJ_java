package S3._2477;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//면적당 과일 수 
		int num = sc.nextInt();
		//6변 길이 입력받기
		int[][] hex = new int[6][2];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				hex[i][j] = sc.nextInt();
			}
		}
		//가로 세로 별로 가장 긴 변의 값과 인덱스 찾기
		int widIdx = -1;
		int heiIdx = -1;
		int widMax = 0;
		int heiMax = 0;
		for(int i = 0; i < 6; i++) {  //동서남북 1234
			//가로일 경우
			if(hex[i][0] == 1 || hex[i][0] == 2) {
				if(widMax < hex[i][1]) {
					widMax = hex[i][1];
					widIdx = i;
				}
			}
			//세로일 경우
			else {
				if(heiMax < hex[i][1]) {
					heiMax = hex[i][1];
					heiIdx = i;
				}
			}
		}
		//큰 직사각형에서 작은 직사각형을 빼줄 것
		//작은 직사각형은 큰 변에서 각각 두칸 씩 떨어있는 변으로 구성
		int small1 = 0;
		int small2 = 0;
		//두 인덱스가 0과 5일땐 최대 최소로 비교 불가
		if(Math.min(heiIdx, widIdx) == 0 && Math.max(heiIdx, widIdx) == 5) {
			small1 = hex[2][1];
			small2 = hex[3][1];
		} 
		//0과 5가 아닌 경우
		else {
			//둘 중 작은 인덱스 - 2
			if(Math.min(heiIdx, widIdx) <= 1) small1 = hex[4+Math.min(heiIdx, widIdx)][1];
			else small1 = hex[Math.min(heiIdx, widIdx) - 2][1];
			//둘 중 큰 인덱스 + 2
			if(Math.max(heiIdx, widIdx) >= 4) small2 = hex[Math.max(heiIdx, widIdx) - 4][1];
			else small2 = hex[Math.max(heiIdx, widIdx) + 2][1];
		}
		//농장 면적 = 큰 직사각형 - 작은 직사각형
		int area = widMax * heiMax - small1 * small2;
		
		//총 과일 수는 농장 면적 * 면적당 과일 수 
		System.out.println(area * num);
			
	}

}
