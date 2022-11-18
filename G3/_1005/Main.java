package G3._1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] times = new int[N+1];
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            int[] inDegree = new int[N+1];
            ArrayList<Integer>[] adjList = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int sta = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList[sta].add(end);
                inDegree[end]++;
            }
            int win = Integer.parseInt(in.readLine());
            int[] wait = new int[N+1];
            boolean[] visited = new boolean[N+1];
            while(inDegree[win] > 0) {
                for (int i = 1; i <= N; i++) {
                    if(!visited[i] && inDegree[i] == 0) {
                        for (int j = 0; j < adjList[i].size(); j++) {
                            wait[adjList[i].get(j)] = Math.max(wait[adjList[i].get(j)], wait[i] + times[i]);
                            inDegree[adjList[i].get(j)]--;
                        }
                        visited[i] = true;
                    }
                }
            }
            System.out.println(wait[win] + times[win]);
        }
    }
}
