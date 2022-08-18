package S2._23304;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		//결과 출력
		if(isAka(text)) System.out.println("AKARAKA");
		else System.out.println("IPSELENTI");
		sc.close();
	}
	
	//펠린드롬인지 확인하는 메소드
	static boolean isPal(String text) {
		StringBuilder sb = new StringBuilder(text);
		//거꾸로 돌려준다.
		String rev = sb.reverse().toString();
		//거꾸로 돌린 것과 일치하면 회문
		return rev.equals(text);
	}
	
	//아카라카펠린드롬인지 확인하는 메소드
	static boolean isAka(String text) {
		//기저 조건
		if(text.length() == 1) return true;
		//반복 파트
		//회문인지 확인
		if(!isPal(text)) return false;
		else {
			//각각의 접두사 접미사가 아카라카 펠린드롬인지 확인
			String sub1;
			if(text.length() % 2 == 0) sub1 = text.substring(text.length() / 2);
			else sub1 = text.substring(text.length() / 2 + 1);
			String sub2 = text.substring(0, text.length() / 2);
			return isAka(sub1) && isAka(sub2);
		}
		
	}
}
