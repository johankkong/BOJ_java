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
		while (true) {
			char curr = (char) in.read();
			if (curr == 13)
				break;
			text.offer(curr);
		}
		List<Character> bomb = new ArrayList<>();
		while (true) {
			char curr = (char) in.read();
			if (curr == 13)
				break;
			bomb.add(curr);
		}
		bomb.remove(0);
		Queue<Character> tmp = new LinkedList<>();
		int idx = 0;
		int len1 = text.size();
		int len2 = -1;
		while (len2 != 0 && len1 != len2) {
			len1 = text.size();
			for (int i = 0; i < len1; i++) {
				if (tmp.size() == bomb.size()) {
					tmp.clear();
					idx = 0;
				}
				if (text.peek() == bomb.get(idx)) {
					tmp.offer(text.poll());
					idx++;
				} else {
					while (!tmp.isEmpty())
						text.offer(tmp.poll());
					idx = 0;
					if (text.peek() == bomb.get(idx)) {
						tmp.offer(text.poll());
						idx++;
					} else
						text.offer(text.poll());
				}
			}
			len2 = text.size();
		}
		if (text.isEmpty())
			System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while (!text.isEmpty())
				sb.append(text.poll());
			System.out.println(sb);
		}
	}
}