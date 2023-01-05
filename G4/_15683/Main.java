package G4._15683;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] office;
    static List<int[]> cctvs;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        // CCTV 위치와 좌표를 저장할 List
        cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] > 0 && office[i][j] < 5) cctvs.add(new int[] {i, j});
            }
        }
        // cctv 5 가 있는 곳은 십자표시
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(office[i][j] == 5) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        while(ni >= 0 && ni < N && nj >= 0 && nj < M && office[ni][nj] < 6) {
                            if(office[ni][nj] == 0) office[ni][nj] = -1;
                            ni += dr[k];
                            nj += dc[k];
                        }
                    }
                }
            }
        }
        direction = new int[cctvs.size()];
        // 최소 사각지대의 수
        answer = Integer.MAX_VALUE;
        // CCTV를 돌리는 모든 경우의 수를 고려
        turn(0);

        System.out.println(answer);
    }
    static int answer;
    // 각 CCTV의 방향을 기록할 배열
    static int[] direction;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // dfs를 이용하여 모든 경우의 수를 고려
    static void turn(int depth) {
        // 모든 CCTV를 조작한 경우 사각 지대의 수를 계산
        if(depth == cctvs.size()) {
            // 기존 office를 깊은 복사
            int[][] officeCopy = new int[N][M];
            for (int i = 0; i < N; i++) {
                officeCopy[i] = office[i].clone();
            }
            // CCTV를 통해 감시할 수 있는 위치를 표시
            for (int num = 0; num < depth; num++) {
                int[] cctv = cctvs.get(num);
                switch (officeCopy[cctv[0]][cctv[1]]) {
                    case 1:
                        switch (direction[num]) {
                            case 0:
                                int d = 0;
                                int ni = cctv[0] + dr[d];
                                int nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 1:
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 2:

                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 3:

                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {

                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (direction[num]) {
                            case 0:
                            case 1:
                                int d = 0;
                                int ni = cctv[0] + dr[d];
                                int nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 2:
                            case 3:
                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (direction[num]) {
                            case 0:
                                int d = 0;
                                int ni = cctv[0] + dr[d];
                                int nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 1:
                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 2:
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 3:
                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 0;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                        }
                        break;
                    case 4:
                        switch (direction[num]) {
                            case 0:
                                int d = 0;
                                int ni = cctv[0] + dr[d];
                                int nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 1:
                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 0;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 2:
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 3;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                            case 3:
                                d = 2;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 0;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                d = 1;
                                ni = cctv[0] + dr[d];
                                nj = cctv[1] + dc[d];
                                while(ni >= 0 && ni < N && nj >= 0 && nj < M && officeCopy[ni][nj] < 6) {
                                    if(officeCopy[ni][nj] == 0) officeCopy[ni][nj] = -1;
                                    ni += dr[d];
                                    nj += dc[d];
                                }
                                break;
                        }
                        break;
                }
            }
            // 0의 갯수를 센다.
            int blackArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(officeCopy[i][j] == 0) blackArea++;
                }
            }
            answer = Math.min(answer, blackArea);
            return;
        }
        // 0~3을 돌아가면서 저장
        for (int i = 0; i < 4; i++) {

            direction[depth] = i;
            turn(depth + 1);
        }
    }
}
