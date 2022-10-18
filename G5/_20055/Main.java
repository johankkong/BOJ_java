package G5._20055;

import java.io.*;
import java.util.*;

public class Main {
	static class Belt {
		Belt next;
		Belt prev;
		boolean robot;
		int dur;

		public Belt(int dur) {
			super();
			this.dur = dur;
			this.robot = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Belt put = null;
		Belt down = null;
		Belt tmp = null;
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= 2 * N; i++) {
			Belt curr = new Belt(Integer.parseInt(st.nextToken()));
			if (i == 1)
				put = curr;
			if (i == N)
				down = curr;
			if (tmp != null)
				tmp.next = curr;
			curr.prev = tmp;
			tmp = curr;
		}
		// 처음과 끝 연결하기
		put.prev = tmp;
		tmp.next = put;
		// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		int zero = 0;
		int step = 1;
		while (true) {
			// 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			put = put.prev;
			down = down.prev;
			if(down.robot) {
				down.robot = false;
			}
			// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			for (tmp = down; tmp != put; tmp = tmp.prev) {
				if (tmp.dur > 0 && !tmp.robot && tmp.prev.robot) {
					tmp.robot = true;
					tmp.prev.robot = false;
					if(--tmp.dur == 0) {
						++zero;
					}
					if (tmp == down)
						tmp.robot = false;
				}
			}
			// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (put.dur > 0) {
				put.robot = true;
				if(--put.dur == 0) {
					++zero;
				}
			}
			//내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다
			if(zero >= K) break;
			//단계 증가시키기
			step++;
		}
		//진행 중이었던 단계를 출력한다.
		System.out.println(step);
	}
}
