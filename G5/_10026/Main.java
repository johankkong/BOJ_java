package G5._10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
   static int n;
   static char[][] paint;

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      paint = new char[n][n];
      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < n; j++) {
            paint[i][j] = str.charAt(j);
         }
      }
//      StringBuilder sb = new StringBuilder();
//      for(int i = 0; i<n; i++) {
//         for(int j = 0; j<n; j++) {
//            sb.append(paint[i][j]).append(" ");
//         }
//         sb.append("\n");
//      }
//      System.out.println(sb.toString());

      int a = normal();
      int b = colorweak();
      System.out.printf("%d %d", a, b);
   }

   static int[] di = { -1, 0, 1, 0 };
   static int[] dj = { 0, 1, 0, -1 };

   private static int normal() {
      int cnt = 0;
      char curr = 'R';
      Queue<int[]> que = new LinkedList<>();
      boolean[][] visited = new boolean[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
               curr = paint[i][j];
               que.add(new int[] { i, j });
               visited[i][j] = true;
               while (!que.isEmpty()) {
                  int[] now = que.poll();
                  int si = now[0];
                  int sj = now[1];
                  for (int d = 0; d < 4; d++) {
                     int ni = si + di[d];
                     int nj = sj + dj[d];
                     if (ni >= 0 && nj >= 0 && ni < n && nj < n && paint[ni][nj]==curr
                           && !visited[ni][nj]) {
                        que.add(new int[] { ni, nj });
                        visited[ni][nj] = true;
                     }
                  }
               }
               cnt++;
            }
         }
      }
      return cnt;
   }

   private static int colorweak() {
      int cnt = 0;
      char curr = 'R';
      Queue<int[]> que = new LinkedList<>();
      boolean[][] visited = new boolean[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
               curr = paint[i][j];
               que.add(new int[] { i, j });
               visited[i][j] = true;
               while (!que.isEmpty()) {
                  int[] now = que.poll();
                  int si = now[0];
                  int sj = now[1];
                  for (int d = 0; d < 4; d++) {
                     int ni = si + di[d];
                     int nj = sj + dj[d];
                     if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                        if (paint[ni][nj]==curr) {
                           que.add(new int[] { ni, nj });
                           visited[ni][nj] = true;
                        } else if ((curr=='R' || curr=='G')
                              && ((paint[ni][nj]=='R' || paint[ni][nj]=='G'))) {
                           que.add(new int[] { ni, nj });
                           visited[ni][nj] = true;
                        }
                     }
                  }
               }
               cnt++;
            }
         }
      }
      return cnt;
   }

}