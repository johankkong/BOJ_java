package G5._2096;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	//2개의 DP를 만들어야한다.
	//1개는 최대, 1개는 최소
	//문제는 내려가기 이지만, DP를 이용하기 위해선 거꾸로 올라가야한다.
	//아랫줄에 갈 수 있는 칸들 중, 최대 혹은 최소에 자신 칸의 값을 더해가면서 만든다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//최소 dp와 최대 dp를 생성
		int[][] minDP = new int[N][3];
		int[][] maxDP = new int[N][3];
		minDP[N-1] = arr[N-1].clone();
		maxDP[N-1] = arr[N-1].clone();
		//아래에서 부터 거꾸로 채워 올라간다.
		for (int i = N - 2; i >= 0; i--) {
			minDP[i][0] = Math.min(minDP[i+1][0], minDP[i+1][1]) + arr[i][0];
			minDP[i][1] = Math.min(minDP[i+1][2], Math.min(minDP[i+1][0], minDP[i+1][1])) + arr[i][1];
			minDP[i][2] = Math.min(minDP[i+1][1], minDP[i+1][2]) + arr[i][2];
			maxDP[i][0] = Math.max(maxDP[i+1][0], maxDP[i+1][1]) + arr[i][0];
			maxDP[i][1] = Math.max(maxDP[i+1][2], Math.max(maxDP[i+1][0], maxDP[i+1][1])) + arr[i][1];
			maxDP[i][2] = Math.max(maxDP[i+1][1], maxDP[i+1][2]) + arr[i][2];
		}
		//맨 위 줄에서 최대와 최소를 각각 구한다.
		int maxAns = Math.max(maxDP[0][2], Math.max(maxDP[0][0], maxDP[0][1]));
		int minAns = Math.min(minDP[0][2], Math.min(minDP[0][0], minDP[0][1]));
		//결과를 출력
		System.out.println(maxAns + " " + minAns);
	}
}
