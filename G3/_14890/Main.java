package G3._14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 테스트에 사용될 한 줄 배열
        int[] line = new int[N];
        // 지나갈 수 있는 길의 수
        answer = 0;
        // 행 테스트하기
        for (int i = 0; i < N; i++) {
            line = map[i].clone();
            test(line);
        }
        //열 테스트하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                line[j] = map[j][i];
            }
            test(line);
        }
        // 결과 출력
        System.out.println(answer);
    }

    // 한 줄을 매개변수로 지나갈 수 있는 길인지 판단하는 메소드
    static void test(int[] line) {
        //경사로가 설치되어있는 곳인지 저장
        boolean[] occupied = new boolean[N];
        // 두번째 칸부터 이전 칸과의 비교를 통해 경사로를 놓을 수 있는지 판단한다.
        for (int i = 1; i < N; i++) {
            // 이전칸과 같다면 다음 칸으로 넘어감
            if(line[i] == line[i - 1]) continue;
            // 이전 칸과의 차이가 2 이상이면 경로 통과 불가
            else if(Math.abs(line[i] - line[i - 1]) >= 2) return;
            // 내리막이면 경사로를 놓을 수 있는 지 판단
            else if(line[i] - line[i - 1] == -1){
                int curr = line[i];
                // L만큼의 자리가 있는 지 확인
                if(i + L - 1 >= N) return;
                for (int j = 0; j <= L - 1; j++) {
                    if(line[i + j] != curr) return;
                    occupied[i + j] = true;
                }
                // 위 조건을 통과했다면 경사로를 놓을 수 있다.
                i += L - 1;
            }
            // 오르막이면 이전칸에 경사로를 놓을 수 있는지 판단
            else {
                if(i - L < 0) return;
                int curr = line[i - 1];
                // 경사로를 놓을 수 있는지 확인
                for (int j = 1; j <= L; j++) {
                    if(occupied[i - j]) return;
                    if(curr != line[i - j]) return;
                }
            }
        }
        // 위 조건들을 모두 통과하면 통과할 수 있는 길이다.
        answer++;
    }
}
