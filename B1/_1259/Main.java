package B1._1259;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		boolean flag = true;
		while(!num.equals("0")) {
			for(int i = 0; i < num.length() / 2; i++) {
				if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					System.out.println("no");
					flag = false;
					break;
				} 
			}
			if(flag)
				System.out.println("yes");
			flag = true;
			num = sc.next();
		}
		sc.close();
	}
}
