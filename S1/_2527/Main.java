package S1._2527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 4; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[][] sq1 = { { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) },
					{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) } };
			int[][] sq2 = { { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) },
					{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) } };
			// sq1을 기준으로 sq2의 좌표의 위치에 따라 상태를 결정
			// 1. 안 만나는 경우
			if (sq2[1][1] < sq1[0][1] || sq1[1][1] < sq2[0][1] || sq2[1][0] < sq1[0][0] || sq1[1][0] < sq2[0][0])
				System.out.println("d");
			// 2. 한점에서 만나는 경우
			else if (Arrays.equals(sq2[1], sq1[0]) || Arrays.equals(sq1[1], sq2[0])
					|| (sq1[0][0] == sq2[1][0] && sq1[1][1] == sq2[0][1])
					|| (sq1[0][1] == sq2[1][1] && sq1[1][0] == sq2[0][0]))
				System.out.println("c");
			// 3. 선으로 만나는 경우
			else if (sq2[1][0] == sq1[0][0] || sq2[1][1] == sq1[0][1] || sq1[1][1] == sq2[0][1]
					|| sq1[1][0] == sq2[0][0])
				System.out.println("b");
			// 4. 직사각형은 나머지
			else
				System.out.println("a");
		}
	}
}
