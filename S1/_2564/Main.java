package S1._2564;

import java.util.Scanner;

public class Main {
	static int minDistance(int wid, int hei, int[] store, int[] dong) {
		int min = 0;
		int total = wid * 2 + hei * 2;
		switch(dong[0]) {
		case 1:
			switch(store[0]) {
			case 1:
				min = Math.abs(dong[1] - store[1]);
				break;
			case 2:
				int tmp = hei+dong[1]+store[1];
				min = Math.min(tmp, total - tmp);
				break;
			case 3:
				min = dong[1] + store[1];
				break;
			case 4:
				min = (wid - dong[1]) + store[1];
				break;
			}
			break;
		case 2:
			switch(store[0]) {
			case 1:
				int tmp = hei+dong[1]+store[1];
				min = Math.min(tmp, total - tmp);
				break;
			case 2:
				min = Math.abs(dong[1] - store[1]);
				break;
			case 3:
				min = dong[1] + (hei - store[1]);
				break;
			case 4:
				min = (wid - dong[1]) + (hei - store[1]);
				break;
			}
			break;
		case 3:
			switch(store[0]) {
			case 1:
				min = dong[1] + store[1];
				break;
			case 2:
				min = store[1] + (hei - dong[1]);
				break;
			case 3:
				min = Math.abs(dong[1] - store[1]);
				break;
			case 4:
				int tmp = wid+dong[1]+store[1];
				min = Math.min(tmp, total - tmp);
				break;
			}
			break;
		case 4:
			switch(store[0]) {
			case 1:
				min = dong[1] + (wid - store[1]);
				break;
			case 2:
				min = store[1] + (hei - dong[1]);
				break;
			case 3:
				int tmp = wid+dong[1]+store[1];
				min = Math.min(tmp, total - tmp);
				break;
			case 4:
				min = Math.abs(dong[1] - store[1]);
				break;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wid = sc.nextInt();
		int hei = sc.nextInt();
		int num = sc.nextInt();
		int[][] stores = new int[num][2];
		for(int i = 0; i < num; i++) {
			stores[i][0] = sc.nextInt();
			stores[i][1] = sc.nextInt();
		}
		int[] dong = new int[2];
		dong[0] = sc.nextInt();
		dong[1] = sc.nextInt();
		
		int result = 0;
		for(int i = 0; i < num; i++) {
			result += minDistance(wid, hei, stores[i], dong);
		}
		
		System.out.println(result);
	}

}
