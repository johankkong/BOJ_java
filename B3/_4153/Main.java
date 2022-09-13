package B3._4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = in.readLine();
		while(!data.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(data);
			int[] lines = new int[3];
			for(int i = 0; i < 3; i++) {
				lines[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(lines);
			if(Math.pow(lines[0], 2) + Math.pow(lines[1], 2) == Math.pow(lines[2], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			data = in.readLine();
		}
	}
}
