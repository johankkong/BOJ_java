package S3._10972;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//topIdxã��
		int topIdx = 0;
		for(int i = arr.length - 1; i > 0; i--) {
			if(arr[i - 1] < arr[i]) {
				topIdx = i;
				break;
			}
		}
		if(topIdx == 0) {
			System.out.println(-1);
			return;
		}
		
		//�������� ã��
		int cliffIdx = topIdx - 1;
		
		//�ڿ��� ���� �������� ���� ū �� ã��
		int switchIdx = -1;
		for(int i = arr.length - 1; i > cliffIdx; i--) {
			if(arr[cliffIdx] < arr[i]) {
				switchIdx = i;
				break;
			}
		}
		
		//���� ��ȯ�ϱ�
		int temp = arr[switchIdx];
		arr[switchIdx] = arr[cliffIdx];
		arr[cliffIdx] = temp;
		
		//�����ʺ��� �������� �����ٲٱ�
		int rightIdx = arr.length - 1;
		int leftIdx = topIdx;
		 while(leftIdx < rightIdx) {
			 temp = arr[leftIdx];
			 arr[leftIdx] = arr[rightIdx];
			 arr[rightIdx] = temp;
			 rightIdx--;
			 leftIdx++;
		 }
		 
		 //����ϱ�
		 StringBuilder sb = new StringBuilder();
		 for(int c : arr)
			 sb.append(c).append(" ");
		System.out.println(sb);
	}
}
