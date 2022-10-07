package G5._20055;

import java.io.*;
import java.util.*;

public class Main {
	static class Belt {
		Belt next;
		Belt prev;
		boolean robot;
		int dur;
		public Belt(int dur) {
			super();
			this.dur = dur;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Belt put = null;
		Belt down = null;
		Belt tmp = null;
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= 2 * N; i++) {
			Belt curr = new Belt(Integer.parseInt(st.nextToken()));
			if(i == 1) put = curr;
			if(i == N) down = curr;
			if(tmp != null) tmp.next = curr;
			curr.prev = tmp;
			tmp = curr;
		}
		
	}
}
