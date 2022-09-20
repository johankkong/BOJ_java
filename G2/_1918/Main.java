package G2._1918;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문자열로 입력 받기
		String text = sc.next();
		
		//연산자를 담을 stack
		Stack<Character> stack = new Stack<>();
		
		//연산자 우선 순위를 담은 Map
		Map<Character, Integer> map = new HashMap<>();
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		
		//결과를 저장할 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		//문자열에서 하나씩 읽으면서
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			switch(c) {
			//'('인 경우 무조건 stack에 담기
			case '(':
				stack.push(c);
				break;
			//')'인 경우 stack에서 '('이 나올 때까지 뽑기
			case ')':
				while(stack.peek() != '(')
					sb.append(stack.pop());
				//'(' 하나 마저 제거
				stack.pop();
				break;
			//나머지 연산자의 경우
			case '+':
			case '-':
			case '*':
			case '/':
				//stack이 비거나 자신보다 낮은 우선순위가 나올 때까지 stack에서 뺀다.
				while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(c))
					sb.append(stack.pop());
				//그리고 지금 연산자를 넣어준다.
				stack.push(c);
				break;
			//연산자가 아닌 경우 바로 담는다.
			default:
				sb.append(c);
			}
		}
		//문자열을 모두 읽고 난 뒤, stack에 남아 있는 것을 모두 빼준다.
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		//sb를 출력한다.
		System.out.println(sb);
		
		sc.close();
	}
}
