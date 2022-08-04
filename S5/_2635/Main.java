package S5._2635;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		List<Integer> maxList = new ArrayList<>();
		for(int second = first; second >= 1; second--) {
			int ftmp = first;
			int stmp = second;
			List<Integer> nums = new ArrayList<>();
			nums.add(ftmp);
			nums.add(stmp);
			while(nums.get(nums.size()-2) - nums.get(nums.size()-1) >= 0) {
				nums.add(nums.get(nums.size()-2) - nums.get(nums.size()-1));
			}
			if(nums.size() > maxList.size())
				maxList = nums;
		}
		System.out.println(maxList.size());
		for(int num : maxList) {
			System.out.print(num + " ");
		}
	}

}
