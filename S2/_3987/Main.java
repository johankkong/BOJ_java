package S2._3987;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[][] space = new String[N][];
		for(int i = 0; i < N; i++) {
			space[i] = sc.next().split("");
		}
		//상, 우, 하, 좌
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int str = sc.nextInt() - 1;
		int stc = sc.nextInt() - 1;
		
		int cnt = 0;
		
		int[] counts = new int[4];
		
		out : for(int d = 0; d < 4; d++) {  //초기 출발 방향 
			cnt = 1;
			int nr = str + dr[d];
			int nc = stc + dc[d];
			int td = d;
			while(nr >= 0 && nr < N && nc >= 0 && nc < M && !space[nr][nc].equals("C")) {
				if(nr == str && nc == stc && td == d) {
					counts[d] = -1;
					break out;
				}
				cnt++;
				if(space[nr][nc].equals("/")) {
					switch(td) {
					case 0:
						td = 1;
						break;
					case 1:
						td = 0;
						break;
					case 2:
						td = 3;
						break;
					case 3:
						td = 2;
						break;
					}
				} else if(space[nr][nc].equals("\\")) {
					switch(td) {
					case 0:
						td = 3;
						break;
					case 1:
						td = 2;
						break;
					case 2:
						td = 1;
						break;
					case 3:
						td = 0;
						break;
					}
				}
				nr += dr[td];
				nc += dc[td];
			}
			counts[d] = cnt;
		}
		int max = 0;
		int dir = -1;
		String urdl = "URDL";
		for(int i = 0; i < 4; i++) {
			if(counts[i] == -1) {
				dir = i;
				max = -1;
				break;
			} else {
				if(max < counts[i]) {
					dir = i;
					max = counts[i];
				}
			}
		}
		if(max == -1) {
			System.out.println(urdl.charAt(dir));
			System.out.println("Voyager");
		} else {
			System.out.println(urdl.charAt(dir));
			System.out.println(max);
		}
	}
}
