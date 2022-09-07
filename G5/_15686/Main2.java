package G5._15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
	static int N, M;
	static int[][] arr;
	static List<int[]> list;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<>(); //치킨집의 위치를 저장할 list 선언
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 2) {
					list.add(new int[] {i, j}); //치킨집의 위치를 배열로 list에 저장
				}
			}	
		}
		selected = new boolean[list.size()]; //조합에 사용할 boolean배열
		ans = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(ans);
	}
	static int ans;
	static void combination(int depth, int start) {
		if(depth == M) {  //M개를 뽑았다면
			ans = Math.min(ans, chicken());
			return;
		}
		for(int i = start; i < list.size(); i++) {
			selected[i] = true;
			combination(depth + 1, i + 1);
			selected[i] = false;
		}
	}
	
	static int chicken() {
		int tmp = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) { //배열의
				if(arr[i][j] == 1) {  //모든 집에 대해서
					int localMin = N * 2;
					for(int k = 0; k < list.size(); k++) {  //선택된 치킨집들 중의 최소값을 더한다.
						if(selected[k]) {
							localMin = Math.min(localMin, Math.abs(i - list.get(k)[0]) + Math.abs(j - list.get(k)[1]));
						}
					}
					tmp += localMin;
				}
			}
		}
		return tmp;
	}
}
