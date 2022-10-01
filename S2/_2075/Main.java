package S2._2075;

import java.io.*;
import java.util.*;

public class Main {
	//N x N 크기의 배열에서 N번째로 큰 수를 찾는 문제
	//맨 아랫줄 부터, N번째로 큰 수를 구하고 그 윗줄을 탐색
	//현재 N번째로 큰 수보다 작은 수가 있는 열은 제외
	//모든 줄이 제외된 상태에서의 수가 답
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()); 
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//더 이상 방문하지 않아도 되는 열을 저장할 boolean배열
		boolean[] expired = new boolean[N];
		
		//숫자를 넣을 리스트
		List<Integer> list = new ArrayList<>();
		
		//답이 될 N번째 수
		int ans = Integer.MIN_VALUE;
		
		//맨 아랫열부터
		for (int i = N - 1; i >= 0; i--) {
			//각 칸을 Node로 만들어 list에 저장한다.
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if(!expired[j] && arr[i][j] > ans) {
					list.add(arr[i][j]);
					flag = true;
				} else {
					expired[j] = true;
				}
			}
			if(!flag) break;
			//list를 정렬
			Collections.sort(list, (n1, n2) -> n2 - n1);
			//N번째 숫자를 뽑는다.
			ans = list.get(N - 1);
		}
		//ans를 출력한다.
		System.out.println(ans);
	}

}
