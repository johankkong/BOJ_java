package S3._2579;

import java.util.Scanner;

public class Main {
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stairNum = sc.nextInt();
		int[] stairs = new int[stairNum + 1];
		for(int i = 1; i < stairNum + 1; i++) {
			stairs[i] = sc.nextInt();
		}
		boolean[] selected = new boolean[stairNum + 1];
		
		stairUp(stairs, selected, 0);
		
		System.out.println(result);
	}
	
	static boolean flag = false;
	static void stairUp(int[] stairs, boolean[] selected, int index) {
		if(selected[index] && selected[index - 1]) flag = true;
		else flag = false;
		//기저 조건
		if(index == stairs.length - 1) {
			int sum = 0;
			for(int i = 0; i < stairs.length; i++) {
				if(selected[i]) sum += stairs[i];
			}
			result = Math.max(result, sum);
			return;
		} else if(index == stairs.length - 2) {
			if(flag) return;
			else {
				int sum = 0;
				for(int i = 0; i < stairs.length; i++) {
					if(selected[i]) sum += stairs[i];
				}
				sum += stairs[stairs.length - 1];
				result = Math.max(result, sum);
				return;
			}
		} else if(index == stairs.length - 3) {
			int sum = 0;
			for(int i = 0; i < stairs.length; i++) {
				if(selected[i]) sum += stairs[i];
			}
			sum += stairs[stairs.length - 1];
			result = Math.max(result, sum);
			return;
		}
		//유도파트
		if(!flag) {
			for(int i = 1; i <= 2; i++) {
				selected[index + i] = true;
				stairUp(stairs, selected, index + i);
				selected[index + i] = false;
			}			
		} else {
			selected[index + 2] = true;
			stairUp(stairs, selected, index + 2);
			selected[index + 2] = false;
		}
	}
}
