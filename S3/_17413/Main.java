package S3._17413;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 원본 문자열 입력 받기
		String origin = sc.nextLine();
		// 새로운 문자열을 만들 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 단어를 뒤집을 stack
		Stack<Character> stack = new Stack<>();
		// 현재 <>태그 안 문자인지 판별할 boolean
		boolean flag = false;
		// 문자열을 차례대로 읽으면서
		for(int i = 0; i < origin.length(); i++) {
			char tmp = origin.charAt(i);
			if(tmp == '<') {  // < 일 경우 sb에 append하고 flag를 true로!
				while(!stack.isEmpty()) sb.append(stack.pop());	//그전에 stack에 남아있다면 다 빼주기
				sb.append(tmp);
				flag = true;
			}
			else if (tmp == '>') {  // > 를 만나면 sb에 append하고 flag를 false로!
				sb.append(tmp);
				flag = false;
			}
			else {  // 태그 기호가 아닌 경우
				if(flag) sb.append(tmp);  // <> 안에 있는 경우, append
				else {  // <> 안에 있는 경우가 아니라면
					if(tmp != ' ') {  //공백이 아닌 경우
						stack.push(tmp);  // 스택에 넣어준다.
					} else {  //공백이라면
						while(!stack.isEmpty()) sb.append(stack.pop());  //스택이 빌때까지 한글자씩 빼서 sb에 append
						sb.append(tmp);  //공백도 append
					}
				}
			}
		}
		//태그로 끝나지 않으면 스택에 남아있기 때문에 남아있는 스택도 붙여줌
		while(!stack.isEmpty()) sb.append(stack.pop());		
		//결과 출력
		System.out.println(sb);
	}
}
