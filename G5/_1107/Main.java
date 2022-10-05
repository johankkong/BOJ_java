package G5._1107;

import java.util.Scanner;

public class Main {
	// 되는 경우의 수
	// 1. 100에서 채널 변경으로 가기
	// 2. 주어진 수보다 크면서 가장 작은 경우
	// 3. 주어진 수보다 작으면서 가장 큰 경우
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cha = sc.nextInt();
		int bro = sc.nextInt();
		boolean[] brokenButtons = new boolean[10];
		for (int i = 0; i < bro; i++) {
			brokenButtons[sc.nextInt()] = true;
		}
		// 1. 100에서 채널 변경으로 가기
		int ans = Math.abs(100 - cha);
		// 앞자리부터 되는 고장 나지 않은 버튼까진 누르기
		String chaS = String.valueOf(cha);
		StringBuilder sb = new StringBuilder();
		//누를 수 있는 수 중에서 가장 큰 수와 가장 작은 수
		int smallest = 11;
		int biggest = -1;
		for (int i = 0; i < 10; i++) {
			if (!brokenButtons[i]) {
				smallest = Math.min(smallest, i);
				biggest = Math.max(biggest, i);
			}
		}
		// 처음으로 못 누르는 자릿수
		int idx = -1;
		for (int i = 0; i < chaS.length(); i++) {
			if (!brokenButtons[chaS.charAt(i) - '0']) {
				sb.append(chaS.charAt(i));
			} else {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			ans = 0;
		} else {
			// 큰 숫자 누를 수 있으면 누르기
			int tmp = chaS.charAt(idx) - '0';
			for (; tmp < 10; tmp++) {
				if (!brokenButtons[tmp]) {
					sb.append(tmp);
					break;
				}
			}
			// 더 큰 수를 누를 수 없다면
			if (tmp == 10) {
				// 이전 수를 하나 늘려야한다.
				// 이전 수가 없다면
				if (idx == 0) {
					// 0을 제외한 가장 작은 버튼을 누르고 나머지를 가장 작은 버튼으로 채운다.
					for (int i = 1; i < 10; i++) {
						if (!brokenButtons[i]) {
							sb.append(i);
							break;
						}
					}
					while (sb.length() != chaS.length() + 1) {
						sb.append(smallest);
					}
					ans = Math.min(ans, count(sb.toString()) + Math.abs(cha - Integer.parseInt(sb.toString())));
				}
				// 이전 수가 있다면
				else {
					sb.setLength(sb.length() - 1);
					for (tmp = chaS.charAt(idx - 1) - '0'; tmp < 10; tmp++) {
						if (!brokenButtons[tmp]) {
							sb.append(tmp);
							break;
						}
					}
					if (tmp != 10) {
						while (sb.length() != chaS.length()) {
							sb.append(smallest);
						}
						ans = Math.min(ans, count(sb.toString()) + Math.abs(cha - Integer.parseInt(sb.toString())));
						System.out.println(sb);
					}
				}
			} else {
				while (sb.length() != chaS.length()) {
					sb.append(smallest);
				}
				ans = Math.min(ans, count(sb.toString()) + Math.abs(cha - Integer.parseInt(sb.toString())));
			}
			// sb 초기화 하고 작은 거 눌러보기
			sb.setLength(idx);
			// 작은 숫자 누를 수 있으면 누르기
			tmp = chaS.charAt(idx) - '0';
			for (; tmp >= 0; tmp--) {
				if (!brokenButtons[tmp]) {
					sb.append(tmp);
					break;
				}
			}
			// 더 작은 수를 누를 수 없다면
			if (tmp == -1) {
				// 이전 수를 하나 줄여야한다.
				// 이전 수가 없다면
				if (idx == 0) {
					// 나머지를 가장 큰 버튼으로 채운다.
					while (sb.length() != chaS.length() - 1) {
						sb.append(biggest);
					}
					ans = Math.min(ans, count(sb.toString()) + Math.abs(cha - Integer.parseInt(sb.toString())));
				}
				// 이전 수가 있다면
				else {
					sb.setLength(sb.length() - 1);
					for (tmp = chaS.charAt(idx - 1) - '0'; tmp >= 0; tmp--) {
						if (!brokenButtons[tmp]) {
							sb.append(tmp);
							break;
						}
					}
					if (tmp != -1) {
						while (sb.length() != chaS.length()) {
							sb.append(biggest);
						}
						ans = Math.min(ans, count(sb.toString()) + Math.abs(cha - Integer.parseInt(sb.toString())));
					}
				}
			} else {
				while (sb.length() != chaS.length()) {
					sb.append(biggest);
				}
				ans = Math.min(ans, count(sb.toString()) + Math.abs(cha - Integer.parseInt(sb.toString())));
			}
		}
		System.out.println(ans);
	}

	static int count(String text) {
		int num = Integer.parseInt(text);
		if(num == 0) return 1;
		int cnt = 0;
		while (num > 0) {
			num /= 10;
			cnt++;
		}
		return cnt;
	}
}