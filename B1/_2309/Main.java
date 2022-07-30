package B1._2309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 9명의 키를 List에 저장
		List<Integer> height = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			height.add(sc.nextInt());
		}

		// 두 명을 제외하는 2중 for문
		out : for (int i = 1; i < 9; i++) {
			for (int j = 0; j < i; j++) {
				//둘을 제외한 나머지의 합이 100일 때
				if(listSum(height, i, j) == 100) {
					//그 둘을 제외 (j부터 remove하면 i의 인덱스가 1 줄어들 것! 주의)
					height.remove(i);
					height.remove(j);
					break out;
				}
			}
		}
		
		//오름차순으로 정렬
		Collections.sort(height);
		
		//결과를 출력
		for(int h : height) {
			System.out.println(h);
		}
	}
	
	//List에서 i번째와 j번째 요소를 제외한 나머지의 합을 구하는 메소드
	static int listSum(List<Integer> list, int i, int j) {
		int sum = 0;
		for(int idx = 0; idx < list.size(); idx++) {
			//idx가 i 혹은 j인 경우 더하지 않는다.
			if(idx == i || idx == j)
				continue;
			else
				sum += list.get(idx);
		}
		return sum;
	}
}
