package S3._2108;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] nums = new int[num]; //배열에 저장
		int sum = 0; //합을 저장
		for(int i = 0; i < num; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		//산술평균을 출력
		System.out.println(Math.round(sum / (double)num));
		
		//배열을 오름차순으로 정렬
		Arrays.sort(nums);
		//중앙값을 출력
		System.out.println(nums[num / 2]);
		
		//최빈값
		Map<Integer, Integer> map = new HashMap<>();
		//값을 key로 횟수를 value로
		for(int i : nums) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);  //이미 존재한다면 1을 더하고
			} else {
				map.put(i, 1);  //없다면 1로 설정
			}
		}
    	List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
    	entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
    	    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
    	    	if(o1.getValue() - o2.getValue() != 0)    //value 값이 같지 않을때 
    	    		return o1.getValue() - o2.getValue();  //먼저 value 값으로 정렬하고(오름차순)
    	    	else return o2.getKey() - o1.getKey();    //value값이 같다면 key값으로 정렬한다.(내림차순-두번째로 작은 값을 위해서)
    	    }
    	});
    	//최빈값이 두개 이상이라면, 두번째를 출력
    	if(entryList.size() > 1 && entryList.get(entryList.size()-1).getValue() == entryList.get(entryList.size()-2).getValue()) {
    		System.out.println(entryList.get(entryList.size()-2).getKey());
    	}
    	//최빈값이 하나인 경우, 그것을 출력
    	else System.out.println(entryList.get(entryList.size()-1).getKey());
    	
    	//범위
    	//요소가 하나라면 0을 출력
    	if(nums.length == 1) System.out.println(0);
    	//최대값과 최소값의 차이를 출력
    	else System.out.println(nums[num - 1] - nums[0]);
	}
	
	

}
