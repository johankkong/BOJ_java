package G3._1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int Node;
        int weight;

        public Edge(int node, int weight) {
            Node = node;
            this.weight = weight;
        }
    }
    static int N, X;
    public static void main(String[] args) throws IOException {
        //출근길, 퇴근길로 나눠서 생각한다.
        //시작지점에서 다익스트라 알고리즘을 통해서, 최단 거리를 구한다.
        //시작 지점에서부터 나가는 간선과 들어오는 간선으로 나누어 다익스트라 알고리즘을 진행한다.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        //입력받는 단방향 간선 인접리스트
        ArrayList<Edge>[] forward = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            forward[i] = new ArrayList<>();
        }
        //반대 방향 간선 인접리스트
        ArrayList<Edge>[] backward = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            backward[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int sta = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int wei = Integer.parseInt(st.nextToken());
            forward[sta].add(new Edge(end, wei));
            backward[end].add(new Edge(sta, wei));
        }
        //순방향 다익스트라 진행 (퇴근길)
        int[] forResult = dijkstra(forward);
        //역방향 다익스트라 진행 (출근길)
        int[] backResult = dijkstra(backward);
        //두 결과의 합 중 최대를 구한다.
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, forResult[i] + backResult[i]);
        }
        System.out.println(ans);
    }
    static class Node implements Comparable<Node> {
        int num;
        int val;
        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
    static int[] dijkstra(ArrayList<Edge>[] ward) {
        int[] result = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;
        while(cnt < N) {
            Node curr = pq.poll();
            while(visited[curr.num]) curr = pq.poll();
            result[curr.num] = curr.val;
            for (Edge edge : ward[curr.num]) {
                pq.add(new Node(edge.Node, curr.val + edge.weight));
            }
            visited[curr.num] = true;
            cnt++;
        }
        return result;
    }
}
