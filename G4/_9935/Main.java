package G4._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character> text = new LinkedList<>();
		while(true) {
			char curr = (char)in.read();
			if(curr == 13) break;
			text.offer(curr);
		}
		List<Character> bomb = new ArrayList<>();
		while(true) {
			char curr = (char)in.read();
			if(curr == 13) break;
			bomb.add(curr);
		}
		System.out.println(text.size());
		bomb.remove(0);
		Queue<Character> tmp = new LinkedList<>();
		int idx = 0;
		for(int i = 0; i < text.size(); i++) {
			char curr = text.poll();
			if(tmp.size() == bomb.size()) {
				tmp = new LinkedList<>();
				idx = 0;
			}
			if(curr == bomb.get(idx)) {
				tmp.offer(curr);
				idx++;
			} else {
				while(!tmp.isEmpty()) text.offer(tmp.poll());
				text.offer(curr);
				idx = 0;
			}
		}
		while(!text.isEmpty()) System.out.print(text.poll());
	}
}
