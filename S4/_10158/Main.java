package S4._10158;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();   //너비와
		int h = sc.nextInt();   //높이를 입력받는다.
		int x = sc.nextInt();   //초기값 x좌표와
		int y = sc.nextInt();   //y좌표를 입력받는다.
		int t = sc.nextInt();   //움직일 시간
		
		int nx = x + t;
		int ny = y + t;  //x와 y에 t만큼 더한다.
		
		int rx = 0;
		int ry = 0;  //결과를 저장할 xy 변수
		//x좌표 결정
		if((nx / w) % 2 == 0) { //너비로 나눈 값이 짝수라면 
			if(nx % w == 0) rx = 0; //경계선일 경우
			else rx = nx % w;   //경계선이 아닌 경우 너비로 나눈 나머지를 그대로 사용
		}
		else {   //너비로 나눈 값이 홀수라면
			if(nx % w == 0) rx = w; //경계선일 경우
			else rx = w - (nx % w);   //경계선이 아닌 경우 너비로 나눈 나머지를 너비에서 빼서 사용
		}
		//y좌표 결정
		if((ny / h) % 2 == 0) { //높이로 나눈 값이 짝수라면 
			if(ny % h == 0) ry = 0; //경계선일 경우
			else ry = ny % h;   //경계선이 아닌 경우 높이로 나눈 나머지를 그대로 사용
		}
		else {   //높이로 나눈 값이 홀수라면
			if(ny % h == 0) ry = h; //경계선일 경우
			else ry = h - (ny % h);   //경계선이 아닌 경우 높이로 나눈 나머지를 높이에서 빼서 사용
		}
		//결과 출력
		System.out.println(rx+" "+ry);
	}

}

//int dx = 1;   //x좌표와 y좌표의 방향이 될 변수
//int dy = 1;
//for(int i = 1; i <= t; i++) {
//	if(x == w) dx = -1; //우변 도달 시 x좌표 방향전환
//	else if(x == 0) dx = 1; //좌변 도달시 x좌표 방향전환
//	if(y == h) dy = -1; //상변 도달 시 y좌표 방향전환
//	else if(y == 0) dy = 1; //하변 도달시 y좌표 방향전환
//	
//	x += dx; //한칸씩 이동
//	y += dy;
//}
////결과출력
//System.out.println(x+" "+y);