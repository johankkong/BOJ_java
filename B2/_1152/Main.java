package B2._1152;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String[] arr = text.split(" ");
		int ans = arr.length;
		if(arr.length != 0 && arr[0].equals("")) ans--;
		System.out.println(ans);
	}
}
