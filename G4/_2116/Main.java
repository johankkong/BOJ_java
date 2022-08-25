package G4._2116;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] dice = new int[num][6];
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 6; j++) {
				dice[i][j] = sc.nextInt();
			}
		}
		//인덱스 기준 (0, 5), (1, 3), (2, 4) 끼리 반대편이다.
		//1번 주사위의 위면이 될 숫자를 선정한다. 
		//가장 첫 줄의 인덱스 0, 1, 2 셋중의 하나만 고르면 된다!
		int ans = 0;
		for(int i = 0; i < 6; i++) {  //1번 주사위 아래면
			int top = dice[0][i];
			int sum = 0;
			for(int j = 0; j < num; j++) {  //1번 주사위부터 마지막 주사위 까지
				int indexB = -1;
				for(int k = 0; k < 6; k++) {
					if(dice[j][k] == top) {
						indexB = k;      //현재 주사위의 아래면 인덱스
						break;
					}
				}
				int indexT = -1;   //현재 주사위의 윗면 인덱스
				switch(indexB) {
				case 0:
					indexT = 5;
					break;
				case 1:
					indexT = 3;
					break;
				case 2:
					indexT = 4;
					break;
				case 3:
					indexT = 1;
					break;
				case 4:
					indexT = 2;
					break;
				case 5:
					indexT = 0;
					break;
				}
				top = dice[j][indexT]; //현재 주사위의 윗면
				int max = 0;
				for(int k = 0; k < 6; k++) { //위 아래값을 제외한 최대값 찾기
					if(k != indexT && k != indexB)
						max = Math.max(max, dice[j][k]);
				}
				sum += max; //해당 층에서 최대값을 sum에 더하기
			}
			ans = Math.max(ans, sum); //6면을 돌려가며 sum의 최대값을 ans에 저장
		}
		//결과 출력
		System.out.println(ans);
	}
}
