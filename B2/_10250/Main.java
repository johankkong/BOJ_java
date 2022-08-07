package B2._10250;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int hei = sc.nextInt();
			int wid = sc.nextInt();
			int n = sc.nextInt();
			//나머지는 층
			//나머지가 0인 경우엔 최고층을 배정
			int flo = n % hei;
			if(flo == 0) flo = hei;
			//몫 + 1은 호수
			//몫이 딱 덜어지는 경우엔 1을 더해주면 안됨
			int roo = (n / hei) + 1;
			if(flo == hei) roo--;
			//층과 호수를 문자열로 붙인다.
			//이때, 호수가 한자릿수 인 경우, 가운데에 0을 넣어줘야함
			if(roo / 10 == 0)
			System.out.println(flo + "0" + roo);
			else
			System.out.println(flo + "" + roo);
		}
	}

}
