package S2._1564;

import java.util.Scanner;

public class Main {
	static int K, N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		arr = new int[K];
		for(int i = 0; i < K; i++) {
			arr[i] =  sc.nextInt();
		}
		
		//잘린 랜선의 갯수
		long cnt = 0;
		//자를 랜선의 길이
		int len = 0;
		//랜선의 길이를 1씩 더해가며 갯수가 N보다 작아질때까지 진행
		do {
			cnt = 0;
			len++;
			//모든 랜선을 길이로 자른다.
			for(int i = 0; i < K; i++) {
				cnt += arr[i] / len;
			}
		} while(cnt >= N);
		//위 반복문을 빠져나오면 갯수가 N보다 작은 첫 길이
		//따라서 그 길이 - 1이 정답이다.
		System.out.println(len - 1);
	}
	
	//이진 탐색으로 최대 길이를 찾아나간다.
	static void binaryS(int left, int right) {
		int mid = (left + right) / 2;
		
	}
	
	//해당 길이로 잘랐을 때 몇개의 랜선이 나오는 지..
	static long cutLen(int len) {
		long cnt = 0;
		for(int line : arr) {
			cnt += line / len;
		}
		return cnt;
	}
}
