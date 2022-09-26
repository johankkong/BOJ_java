package S4._1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] pokemons = new String[N];
		for (int i = 0; i < N; i++) {
			pokemons[i] = in.readLine();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String quest = in.readLine();
			if(quest.charAt(0) <= '9') {
				sb.append(pokemons[Integer.parseInt(quest) - 1]).append("\n");
			} else {
				for (int j = 0; j < N; j++) {
					if(quest.equals(pokemons[j])) {
						sb.append(j + 1).append("\n");
					}
				}
			}
		}
		System.out.println(sb);
		in.close();
	}
}
