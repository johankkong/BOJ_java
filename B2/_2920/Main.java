package B2._2920;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		if(text.equals("1 2 3 4 5 6 7 8")) System.out.println("ascending");
		else if(text.equals("8 7 6 5 4 3 2 1")) System.out.println("descending");
		else System.out.println("mixed");
	}
}
