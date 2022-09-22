package S2._18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int maxH = 0;
		int minH = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, arr[i][j]);
				minH = Math.min(minH, arr[i][j]);
			}
		}

		int time = Integer.MAX_VALUE;
		int height = 0;
		
		for(int localH = minH; localH <= maxH; localH++) {
			int blockNeed = 0;
			int localTime = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(localH < arr[i][j]) {
						blockNeed -= arr[i][j] - localH;
						localTime += 2 * (arr[i][j] - localH);
					}
					else {
						blockNeed += localH - arr[i][j];
						localTime += localH - arr[i][j];
					}
				}
			}
			if(blockNeed > B)
				continue;
			else {
				if(time >= localTime) {
					time = localTime;
					height = localH;
				}
			}
		}
		
		System.out.println(time + " " + height);
	}
}
