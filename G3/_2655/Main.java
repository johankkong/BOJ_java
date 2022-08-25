package G3._2655;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] cols = new int[num][4];
		for (int i = 0; i < num; i++) {
			cols[i][0] = sc.nextInt(); //밑넓이
			cols[i][1] = sc.nextInt(); //높이
			cols[i][2] = sc.nextInt(); //무게
			cols[i][3] = i + 1; //번호
		}
		
		Arrays.sort(cols, new Comparator<int[]>() {  //밑넓이 기준으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		System.out.println();
		
		//dp 배열 선언
		int[][] dp = new int[num][3];  //i번째 블럭을 가장 아래로 하는 최대 높이를 저장, 2열에는 바로 위 블럭 번호를 저장, 3열에 인덱스
		for(int i = 0; i < num; i++) {  //dp배열을 채워나간다.
			int index = -1;
			int number = 0;
			int localMax = 0;
			for(int k = i - 1; k >= 0; k--) {  //자신보다 작은 칸에 대해서만(밑넓이가 작은 블럭들에 대해서만)
				if(cols[i][2] > cols[k][2]) {  //자신보다 무게가 작은 블럭 중에서
					if(localMax < dp[k][0]) {  //최대값을 찾는다
						localMax = dp[k][0];
						number = dp[k][1];
						index = k;
					}
				}
			}
			if(localMax != 0) {  //자신보다 가벼운 블럭이 있다면
				dp[i][0] = localMax + cols[i][1];  //최대 높이에 자신의 높이를 더하고
				dp[i][1] = number;   //그 이전 칸의 번호와
				dp[i][2] = index;    //그 이전 칸의 인덱스를 저장한다.
			} else { //자신보다 가벼운 블럭이 없다면
				dp[i][0] = cols[i][1]; //자신의 높이를 넣는다.
				//나머지는 0 그대로
			}
		}
		System.out.println(Arrays.deepToString(dp));
	}
}
