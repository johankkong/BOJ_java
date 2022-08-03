package B1._14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// N �Է¹ޱ�
		int N = Integer.parseInt(in.readLine());
		// N�� �ݺ�
		out : for (int i = 0; i < N; i++) {
			// A�� B�� ������� ���� �迭 ����
			int[] A = new int[4];
			int[] B = new int[4];
			// A�� ���� �� ��� ������ �迭�� ����
			st = new StringTokenizer(in.readLine());
			// A�� ���� ���� ��
			int number = Integer.parseInt(st.nextToken());
			while(number != 0) {
				// �ε����� Ȱ���ϱ� ���� 1�� ����
				A[Integer.parseInt(st.nextToken()) - 1]++;
				number--;
			}
			// B�� ���� �� ��� ������ �迭�� ����
			st = new StringTokenizer(in.readLine());
			// B�� ���� ���� ��
			number = Integer.parseInt(st.nextToken());
			while(number != 0) {
				// �ε����� Ȱ���ϱ� ���� 1�� ����
				B[Integer.parseInt(st.nextToken()) - 1]++;
				number--;
			}
			// ���ڰ� ū �� ���� ���ϸ� �� ū ���� ���
			for (int j = 3; j >= 0; j--) {
				// ���� ��� ���� ���ڷ� �Ѿ
				if (A[j] == B[j])
					continue;
				// �ٸ� ��� �̱� ����� ����ϰ� break
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
