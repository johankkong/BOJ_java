package G4._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String text = in.readLine();
		String bomb = in.readLine();
		
		Stack<Character> main = new Stack<>();
		Stack<Character> test = new Stack<>();
		
		boolean flag = true;
		
		for(int i = 0; i < text.length(); i++) {
			main.push(text.charAt(i));  //main 스택에 하나씩 push
			if(text.charAt(i) == bomb.charAt(bomb.length() - 1)  //현재 char가 bomb의 마지막 글자와 같고 
					&& main.size() >= bomb.length()) {  //main의 size가 bomb의 길이보다 크다면
				for(int j = bomb.length() - 1; j >= 0; j--) {  //main에서 bomb의 길이만큼 확인한다.
					if(main.peek() == bomb.charAt(j)) {  //bomb의 뒤부터 한 글자씩 비교해서 test에 넣는다.
						test.push(main.pop());
						flag = true;
					} else {	//한글자라도 틀린 경우
						while(!test.isEmpty()) {  //test가 빌 때까지 다시 main에 넣는다.
							main.push(test.pop());
						}
						flag = false;
						break;
					}
				}
				if(flag) { //for문을 끝 냈을 때, flag가 true라면 bomb이 완성됨
					test.clear(); //test를 비워준다.
				}
			}
		} //폭탄 검사를 끝낸 후
		if(main.isEmpty()) { //main이 비어있다면
			System.out.println("FRULA"); //FRULA를 출력
		} else {  //남아있다면
			StringBuilder sb = new StringBuilder();
			while(!main.isEmpty()) {
				sb.append(main.pop());
			}
			System.out.println(sb.reverse()); //스택에서 꺼냈기 때문에 뒤집어 결과를 출력한다.
		}
	}
}