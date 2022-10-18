package G4._17471;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] people;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			for (int j = 0; j < tmp; j++) {
				adjList[i].add(sc.nextInt() - 1);
			}
		}
		//연결될 수 있는 모든 경우의 수를 구한다.
		vote = new boolean[N];
		ans = Integer.MAX_VALUE;
		comb(0);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	static boolean[] vote;
	static int ans;
	private static void comb(int depth) {
		if(depth == N) {
			//선정된 선거구가 연결될 수 있는 지 확인
			if(canConnect()) {
				int diff = 0;
				for (int i = 0; i < N; i++) {
					if(vote[i]) diff += people[i];
					else diff -= people[i];
				}
//				System.out.println(Arrays.toString(vote));
				ans = Math.min(ans, Math.abs(diff));
			}
			return;
		}
		//A선거구 false
		comb(depth + 1);
		//B선거수 true
		vote[depth] = true;
		comb(depth + 1);
		vote[depth] = false;
	}
	private static boolean canConnect() {
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if(vote[i]) {
				dfs(i, true);
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			if(!vote[i]) {
				dfs(i, false);
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
	static boolean[] visited;
	private static void dfs(int i, boolean area) {
		visited[i] = true;
		for (Integer j : adjList[i]) {
			if(!visited[j] && vote[j] == area) dfs(j, area);
		}
	}
}
