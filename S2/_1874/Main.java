package S2._1874;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) 
			queue.offer(i);
		boolean flag = true;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			num = sc.nextInt();
			if(!queue.isEmpty() && num >= queue.peek()) {
				while(num != queue.peek()) {
					stack.push(queue.poll());
					sb.append("+\n");
				}
				queue.poll();
				sb.append("+\n-\n");
			}
			else if(!stack.isEmpty() && num == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			}
			else {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println(sb);
		else System.out.println("NO");
	}
}
