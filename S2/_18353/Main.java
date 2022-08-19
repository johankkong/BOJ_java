package S2._18353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		//전투력을 저장할 list
		List<Integer> pow = new ArrayList<>();
		//전투력을 list에 저장
		StringTokenizer st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			pow.add(Integer.parseInt(st.nextToken()));
		}
		//그 칸까지의 최대 길이를 저장할 dp배열
		int[] dp = new int[num];
		//첫 칸은 최대 길이는 1
		dp[0] = 1;
		//그 다음칸 부터는
		for(int i = 1; i < num; i++) {
			int max = 0;
			//자신보다 앞쪽에 있는 칸들에 대해
			for(int j = 0; j < i; j++) {
				//자신보다 큰 전투력을 가지는 경우 중에서만 최대 dp값을 구한다.
				if(pow.get(i) < pow.get(j)) max = Math.max(max, dp[j]);
			}
			//그 최댓값에 자기자신을 의미하는 1을 더하여 저장한다.
			dp[i] = max + 1;
		}
		//dp배열 중 최대값을 구한다.
		int result = 0;
		for(int i = 0; i < num; i++) result = Math.max(result, dp[i]);
		//결과 출력
		System.out.println(num - result);
	}
}
