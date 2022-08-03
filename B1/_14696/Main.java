package B1._14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// N 입력받기
		int N = Integer.parseInt(in.readLine());
		// N번 반복
		out : for (int i = 0; i < N; i++) {
			// A와 B의 딱지모양 저장 배열 선언
			int[] A = new int[4];
			int[] B = new int[4];
			// A가 가진 각 모양 갯수를 배열에 저장
			st = new StringTokenizer(in.readLine());
			// A가 가진 딱지 수
			int number = Integer.parseInt(st.nextToken());
			while(number != 0) {
				// 인덱스로 활용하기 위해 1을 빼줌
				A[Integer.parseInt(st.nextToken()) - 1]++;
				number--;
			}
			// B가 가진 각 모양 갯수를 배열에 저장
			st = new StringTokenizer(in.readLine());
			// B가 가진 딱지 수
			number = Integer.parseInt(st.nextToken());
			while(number != 0) {
				// 인덱스로 활용하기 위해 1을 빼줌
				B[Integer.parseInt(st.nextToken()) - 1]++;
				number--;
			}
			// 숫자가 큰 쪽 부터 비교하며 더 큰 쪽을 출력
			for (int j = 3; j >= 0; j--) {
				// 같은 경우 다음 숫자로 넘어감
				if (A[j] == B[j])
					continue;
				// 다른 경우 이긴 사람을 출력하고 break
				else if (A[j] > B[j]) {
					System.out.println("A");
					continue out;
				}
				else {
					System.out.println("B");
					continue out;
				}
			}
			System.out.println("D");
		}
	}

}
