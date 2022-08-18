package S4._2164;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();  //카드 수 입력받기
		Queue<Integer> cards = new LinkedList<>();
		for(int i = 1; i <= num; i++) {
			//1부터 순서대로 큐에 넣는다.
			cards.offer(i);
		}
		while(cards.size() != 1) {
			//카드 한 장 버리기
			cards.poll();
			//그 다음 장 다시 맨 아래에 넣기
			cards.offer(cards.poll());
		}
		//남은 한장 출력하기
		System.out.println(cards.poll());
	}

}
