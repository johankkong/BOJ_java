package S2._2304;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ground = new int[1000];
		int num = sc.nextInt();
		for(int i = 0; i < num; i++) {
			ground[sc.nextInt()] = sc.nextInt();
		}
		
	}
	
	static int calculation(int[] arr) {
		//�ִ� ���� ã��
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//���� ���� �ִ� �ε����� ���� �ִ� �ε����� ���Ѵ�.
		int maxLeft = 1000;
		int maxRight = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				maxLeft = Math.min(i, maxLeft);
				maxRight = Math.max(i, maxRight);
			}
		}
		//��������Լ�
		
		//��������Լ�
		
	}

}
