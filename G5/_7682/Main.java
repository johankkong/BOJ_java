package G5._7682;

//1. O의 갯수가 X보다 2개상 작거나, X보다 많으면 invalid
//2. 3를 완성한 갯수가 2개 이상이면 invalid
//	단, X의 갯수가 5이고 X가 3을 두개 만들었다면, valid

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		String game = in.readLine();
		while(!game.equals("end")) {
			char[] arr = game.toCharArray();
			byte cntO = 0;
			byte cntX = 0;
			byte cntO3 = 0;
			byte cntX3 = 0;
			for(int i = 0; i < 9; i++) {
				if(arr[i] == 'O') cntO++;
				if(arr[i] == 'X') cntX++;
			}
			if(cntO > cntX || cntO < cntX - 1) {
				ans.append("invalid").append("\n");
			} else {
				//가로
				for (int i = 0; i < 9; i += 3) {
					if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]) {
						if(arr[i] == 'O') cntO3++;
						else if(arr[i] == 'X') cntX3++;
					}
				}
				//세로
				for (int i = 0; i < 3; i++) {
					if(arr[i] == arr[i+3] && arr[i+3] == arr[i+6]) {
						if(arr[i] == 'O') cntO3++;
						else if(arr[i] == 'X') cntX3++;
					}
				}
				//대각선
				for (int i = 2; i <= 4; i += 2) {
					if(arr[4] == arr[4-i] && arr[4] == arr[4+i]) {
						if(arr[4] == 'O') cntO3++;
						else if(arr[4] == 'X') cntX3++;
					}
				}
				if(cntX == 5 && cntX3 == 2 && cntO3 == 0) {
					ans.append("valid").append("\n");
				} else {
					if(cntO == 4 && cntX == 5 && cntX3 + cntO3 == 0) {
						ans.append("valid").append("\n");
					} else if(cntX3 + cntO3 == 1) {
						if((cntO3 == 1 && cntX > cntO)||(cntX3 == 1 && cntX == cntO)) {
							ans.append("invalid").append("\n");
						} else {
							ans.append("valid").append("\n");
						}
					} else {
						ans.append("invalid").append("\n");
					}
				}
			}
			game = in.readLine();
		}
		System.out.println(ans);
		in.close();
	}
}
