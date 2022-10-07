package G5._1107;

import java.util.*;

public class Main {
	static TreeSet<Integer> broken;
	static int cha;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cha = sc.nextInt();
		int bro = sc.nextInt();
		broken= new TreeSet<>();
		for (int i = 0; i < bro; i++) {
			broken.add(sc.nextInt());
		}
		//초기값은 100에서 +/-로 만 이동하는 경우
		int ans = Math.abs(cha - 100);
		//0부터 500000까지 모든 경우에 대해 판단한다.
		for (int i = 0; i <= 1000000; i++) {
			if(able(i)) {
				ans = Math.min(ans, press(i));
			}
		}
		//결과 출력
		System.out.println(ans);
	}
	//누를수 있는 채널인지 판단
	static boolean able(int channel) {
		do {
			int digit = channel % 10;
			if(broken.contains(digit)) return false;
			channel /= 10;
		} while(channel > 0);
		return true;
	}
	//cha를 만들려면 몇 번 눌러야하는 지 계산
	static int press(int curr) {
		int cnt = Math.abs(curr - cha);
		if(curr == 0) cnt++;
		while(curr > 0) {
			curr /= 10;
			cnt++;
		}
		return cnt;
	}
}