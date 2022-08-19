package S4._10845;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++) {
			String command = sc.next();
			switch(command) {
			case "push":
				queue.offer(sc.nextInt());
				break;
			case "pop":
				if(queue.isEmpty()) sb.append(-1+ "\n");
				else sb.append(queue.poll() + "\n");
				break;
			case "size":
				sb.append(queue.size() + "\n");
				break;
			case "empty":
				if(queue.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
				break;
			case "front":
				if(queue.isEmpty()) sb.append(-1 + "\n");
				else sb.append(queue.peek() + "\n");
				break;
			case "back":
				if(queue.isEmpty()) sb.append(-1 + "\n");
				else{
					Object[] tmp = queue.toArray();
					sb.append(tmp[queue.size() - 1] + "\n");
				}
				break;
			}
		}
		System.out.print(sb);
	}
}