package S4._1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int dud = Integer.parseInt(st.nextToken());
		int bo = Integer.parseInt(st.nextToken());
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < dud; i++) {
			set.add(in.readLine());
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < bo; i++) {
			pq.offer(in.readLine());
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			String tmp = pq.poll();
			if(set.contains(tmp)) {
				sb.append(tmp).append("\n");
				cnt++;
			}
		}
		sb.insert(0, cnt + "\n");
		System.out.println(sb);
	}
}
