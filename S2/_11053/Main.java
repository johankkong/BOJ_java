package S2._11053;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int result = 0;
	static Stack<Integer> stack = new Stack<>();
	static void increase(int[] arr, int start) {
		int tmp = 0;
		for(int i = start; i < arr.length; i++) {
			if(!stack.isEmpty() && arr[i] > stack.peek()) tmp = arr[i];
		}
		if(!stack.isEmpty() && tmp == 0) {
			if(stack.size() > result) result = stack.size();
			return;
		}
		for(int i = start; i < arr.length; i++) {
			if(stack.isEmpty()) {
				stack.push(arr[i]);
			}
			else if(arr[i] > stack.peek()) {
				stack.push(arr[i]);
			}
			increase(arr, i+1);
			if(!stack.isEmpty())stack.pop();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		increase(arr, 0);
		System.out.println(result);
	}
}
