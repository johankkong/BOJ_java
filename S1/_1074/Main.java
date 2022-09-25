package S1._1074;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(where(r, c, N));
	}
	static int where(int r, int c, int depth) {
		if(depth == 1) {
			if(r == 0 && c == 0)
				return 0;
			else if(r == 0 && c == 1)
				return 1;
			else if(r == 1 && c == 0)
				return 2;
			else
				return 3;
		}
		//몇 사분면에 있는지 판단
		if(r < (1 << depth - 1) && c < (1 << depth - 1)) 
			return where(r, c, depth - 1);
		else if(r < (1 << depth - 1) && c >= (1 << depth - 1))
			return (1 << (2 * depth - 2)) + where(r, c - (1 << depth - 1), depth - 1);
		else if(r >= (1 << depth - 1) && c < (1 << depth - 1))
			return (1 << (2 * depth - 2)) * 2 + where(r - (1 << depth - 1), c, depth - 1);
		else
			return (1 << (2 * depth - 2)) * 3 + where(r - (1 << depth - 1), c - (1 << depth - 1), depth - 1);			
	}
}
