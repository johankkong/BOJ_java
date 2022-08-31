package G4._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character> text = new LinkedList<>();
		Queue<Character> bomb = new LinkedList<>();
		while(true) {
			char curr = (char)in.read();
			if(curr == 13) break;
			text.offer(curr);
		}
		while(true) {
			char curr = (char)in.read();
			if(curr == 13) break;
			bomb.offer(curr);
		}
		Queue<Character> tmp = new LinkedList<>();
		do {
			for(int i = 0; i < text.size(); i++) {
				char curr = text.poll();
				if(curr != bomb.peek()) text.offer(curr);
				else {
					
				}
			}
		}
	}
}
