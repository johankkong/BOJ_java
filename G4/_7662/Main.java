package G4._7662;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			TreeSet<pair> MaxTree = new TreeSet<>(new Comparator<pair>() {
				@Override
				public int compare(pair o1, pair o2) {
					return o1.value - o2.value;
				}
			});
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				String comm = sc.next();
				int value = sc.nextInt();
				if(comm.equals("I")) {
					pair p = new pair(value, true);
					MaxTree.add(p);
				} else {
					if(value == 1) {
						if(!MaxTree.isEmpty()) {
							MaxTree.pollFirst();
						}
					}
					else {
						if(!MaxTree.isEmpty()) {
							MaxTree.pollLast();
						}
					}
				}
			}
			if(MaxTree.size() == 0) System.out.println("EMPTY");
			else System.out.println(MaxTree.last().value + " " + MaxTree.first().value);
		}
	}

	static class pair {
		int value;
		boolean flag;

		public pair(int value, boolean flag) {
			super();
			this.value = value;
			this.flag = flag;
		}
	}
}