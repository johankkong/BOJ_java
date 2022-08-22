package S4._12789;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] people = new int[num];
		for(int i = 0; i < num; i++) {
			people[i] = sc.nextInt();
		}
		// 옆에 비켜있는 사람들을 저장할 stack
		Stack<Integer> stack = new Stack<>();
		// 들어갈 차례를 표시할 변수
		int cnt = 1;
		for(int i = 0; i < num; i++) {
			if(people[i] == cnt) cnt++; //들어갈 차례라면 들어가
			else {
				if(!stack.isEmpty() && stack.peek() == cnt) {  //스택에 사람이 있고 들어갈 차례라면
					stack.pop(); //들어가
					cnt++;
					i--; //현재 줄서있는 사람을 다시 판단해야함
				}
				else stack.push(people[i]);  //들어갈 차례가 아니라면 옆으로 비켜
			}
		}
		// stack에 사람이 있을 경우, 차례가 맞는 경우 들어가
		while(!stack.isEmpty() && stack.peek() == cnt) {
			stack.pop();
			cnt++;
		}
		// 스택이 비어 있으면 모두 들어감
		if(stack.isEmpty()) System.out.println("Nice");
		// 아니면 이제 못 들어감
		else System.out.println("Sad");
	}

}
