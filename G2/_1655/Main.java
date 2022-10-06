package G2._1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
		leftPQ.offer(Integer.parseInt(in.readLine()));
		int cnt = 1;
		sb.append(leftPQ.peek()).append("\n");
		while(cnt < N) {
			int tmp = Integer.parseInt(in.readLine());
			if(tmp <= leftPQ.peek()) {
				leftPQ.offer(tmp);
				if(leftPQ.size() - rightPQ.size() == 2) {
					rightPQ.offer(leftPQ.poll());
				}
			}
			else {
				rightPQ.offer(tmp);
				if(rightPQ.size() - leftPQ.size() == 1) {
					leftPQ.offer(rightPQ.poll());
				}
			}
			cnt++;
			sb.append(leftPQ.peek()).append("\n");
		}
		System.out.print(sb);
	}
}
