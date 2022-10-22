package G2._12100;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//중복 순열을 통해서 완전 탐색을 진행
		result = new int[5];
		ans = 0;
		perm(0);
		System.out.println(ans);
	}
	static int[] result;
	static int ans;
	static void perm(int depth) {
		if(depth == 5) {
			//5번 시행의 순서를 모두 정했으므로 순서에 따라 진행
			//작업을 진행할 새로운 배열을 복사
			int[][] tmp = new int[N][N];
			for (int i = 0; i < N; i++) {
				tmp[i] = arr[i].clone();
			}
			//새로운 배열에 정해진 순서대로 2048을 진행
			int local = do2048(tmp);
			//현재 최대값과 비교
			ans = Math.max(ans, local);
			return;
		}
		//모든 칸에 대해서 방향을 지정한다.
		for (int i = 0; i < 4; i++) {
			result[depth] = i;
			perm(depth + 1);
		}
	}
	private static int do2048(int[][] tmp) {
		//정해진 순서대로 진행
		for (int d = 0; d < 5; d++) {
			int dir = result[d];
			//각 방향에 대해 코드를 구현
			switch(dir) {
			case 0: //왼쪽
				//각 행을
				for (int i = 0; i < N; i++) {
					int cnt = 0;
					int cur = -1;
					//왼쪽부터 탐색
					for (int j = 0; j < N; j++) {
						//0이면 넘어감
						if(tmp[i][j] == 0) 
							continue;
						//0이 아니면 현재 값과 비교
						else {
							//첫 숫자라면
							if(cur == -1) {
								//현재 값을 저장
								cur = tmp[i][j];
							}
							//첫 숫자가 아니고 현재 값과 이전 값이 다르면
							else if(tmp[i][j] != cur) {
								tmp[i][cnt++] = cur;
								cur = tmp[i][j];
							}
							//현재 값과 이전 값이 같다면 더해서 저장
							else if(tmp[i][j] == cur) {
								tmp[i][cnt++] = cur * 2;
								cur = -1;
							}
						}
					}
					//탐색을 마친 뒤 cur에 수가 남아 있다면 저장
					if(cur != -1) {
						tmp[i][cnt++] = cur;
					}
					//cnt가 아직 N에 도달하지 못했다면 0으로 채운다.
					while(cnt < N) {
						tmp[i][cnt++] = 0;
					}
				}
				break;
			case 1: //오른쪽
				//각 행을
				for (int i = 0; i < N; i++) {
					int cnt = N - 1;
					int cur = -1;
					//오른쪽부터 탐색
					for (int j = N - 1; j >= 0; j--) {
						//0이면 넘어감
						if(tmp[i][j] == 0) 
							continue;
						//0이 아니면 현재 값과 비교
						else {
							//첫 숫자라면
							if(cur == -1) {
								//현재 값을 저장
								cur = tmp[i][j];
							}
							//첫 숫자가 아니고 현재 값과 이전 값이 다르면
							else if(tmp[i][j] != cur) {
								tmp[i][cnt--] = cur;
								cur = tmp[i][j];
							}
							//현재 값과 이전 값이 같다면 더해서 저장
							else if(tmp[i][j] == cur) {
								tmp[i][cnt--] = cur * 2;
								cur = -1;
							}
						}
					}
					//탐색을 마친 뒤 cur에 수가 남아 있다면 저장
					if(cur != -1) {
						tmp[i][cnt--] = cur;
					}
					//cnt가 아직 N에 도달하지 못했다면 0으로 채운다.
					while(cnt >= 0) {
						tmp[i][cnt--] = 0;
					}
				}
				break;
			case 2: //위쪽
				//각 열을
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					int cur = -1;
					//위쪽부터 탐색
					for (int i = 0; i < N; i++) {
						//0이면 넘어감
						if(tmp[i][j] == 0) 
							continue;
						//0이 아니면 현재 값과 비교
						else {
							//첫 숫자라면
							if(cur == -1) {
								//현재 값을 저장
								cur = tmp[i][j];
							}
							//첫 숫자가 아니고 현재 값과 이전 값이 다르면
							else if(tmp[i][j] != cur) {
								tmp[cnt++][j] = cur;
								cur = tmp[i][j];
							}
							//현재 값과 이전 값이 같다면 더해서 저장
							else if(tmp[i][j] == cur) {
								tmp[cnt++][j] = cur * 2;
								cur = -1;
							}
						}
					}
					//탐색을 마친 뒤 cur에 수가 남아 있다면 저장
					if(cur != -1) {
						tmp[cnt++][j] = cur;
					}
					//cnt가 아직 N에 도달하지 못했다면 0으로 채운다.
					while(cnt < N) {
						tmp[cnt++][j] = 0;
					}
				}
				break;
			case 3: //아래쪽
				//각 열을
				for (int j = 0; j < N; j++) {
					int cnt = N - 1;
					int cur = -1;
					//아래쪽부터 탐색
					for (int i = N - 1; i >= 0; i--) {
						//0이면 넘어감
						if(tmp[i][j] == 0) 
							continue;
						//0이 아니면 현재 값과 비교
						else {
							//첫 숫자라면
							if(cur == -1) {
								//현재 값을 저장
								cur = tmp[i][j];
							}
							//첫 숫자가 아니고 현재 값과 이전 값이 다르면
							else if(tmp[i][j] != cur) {
								tmp[cnt--][j] = cur;
								cur = tmp[i][j];
							}
							//현재 값과 이전 값이 같다면 더해서 저장
							else if(tmp[i][j] == cur) {
								tmp[cnt--][j] = cur * 2;
								cur = -1;
							}
						}
					}
					//탐색을 마친 뒤 cur에 수가 남아 있다면 저장
					if(cur != -1) {
						tmp[cnt--][j] = cur;
					}
					//cnt가 아직 N에 도달하지 못했다면 0으로 채운다.
					while(cnt >= 0) {
						tmp[cnt--][j] = 0;
					}
				}
				break;
			}
		}
		//순서에 따라서 이동을 마친 뒤 배열 내 최대값을 찾는다.
		int local = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(local < tmp[i][j]) {
					local = tmp[i][j];
				}
			}
		}
		//최대값을 반환한다.
		return local;
	}
}
