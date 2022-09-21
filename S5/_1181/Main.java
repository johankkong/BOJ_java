package S5._1181;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		List<String> list = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			list.add(sc.next());
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())
					return o1.compareTo(o2);
				else
					return o1.length() - o2.length();
			}
			
		});
		
		list.stream().distinct().forEachOrdered(System.out::println);
	}
}
