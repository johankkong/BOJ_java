package B2._13300;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 행 : 성별, 열 : 학년
		int[][] students = new int[2][6];
		//전체 학생 수
		 int total = sc.nextInt();
		 //한 방에 들어갈 수 있는 사람수
		 int cnt = sc.nextInt();
		 for(int i = 0; i < total; i++) {
			//성별 저장
			 int gender = sc.nextInt(); 		
			//학년 저장 : 인덱스로 직접 사용하기 위해 1을 뺀다.
			 int year = sc.nextInt() - 1;
			 students[gender][year]++;			 
		 }
		 //필요한 방의 수를 저장할 변수
		 int room = 0;
		 //배열을 탐색하면서 몇개의 방이 필요한지 계산
		 for(int i = 0; i < 2; i++) {
			 for(int j = 0; j < 6; j++) {
				 room += students[i][j] / cnt;
				 //나누어떨어지지 않는 경우 1을 더한다.
				 if (students[i][j] % cnt != 0)
					 room++;
			 }			 
		 }
		 System.out.println(room);
		 sc.close();
	}
}
