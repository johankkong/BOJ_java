package S4._1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> pokemonsMap = new HashMap<>();
		String[] pokemonsArr = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			String pokemon = in.readLine();
			pokemonsMap.put(pokemon, i);
			pokemonsArr[i] = pokemon;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String quest = in.readLine();
			if(quest.charAt(0) <= '9') {
				sb.append(pokemonsArr[Integer.parseInt(quest)]).append("\n");
			} else {
				sb.append(pokemonsMap.get(quest)).append("\n");
			}
		}
		System.out.println(sb);
		in.close();
	}
}
