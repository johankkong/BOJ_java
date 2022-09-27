package G4._7662;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				String comm = sc.next();
				int value = sc.nextInt();
				if (comm.equals("I")) {
					map.put(value, map.getOrDefault(value, 0) + 1);
				} else {
					if (map.size() == 0) {
						continue;
					}
					if (value == -1) {
						Entry<Integer, Integer> ent = map.pollFirstEntry();
						if (ent.getValue() == 1) {
							continue;
						} else {
							map.put(ent.getKey(), ent.getValue() - 1);
						}
					} else {
						Entry<Integer, Integer> ent = map.pollLastEntry();
						if (ent.getValue() == 1) {
							continue;
						} else {
							map.put(ent.getKey(), ent.getValue() - 1);
						}
						
					}
				}
			}
			if (map.size() == 0)
				System.out.println("EMPTY");
			else
				System.out.println(map.lastKey() + " " + map.firstKey());
		}
	}
}