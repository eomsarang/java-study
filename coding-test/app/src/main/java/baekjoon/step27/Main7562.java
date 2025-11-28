package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7562 {


  static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      int l = Integer.parseInt(br.readLine());
      StringTokenizer st;

      st = new StringTokenizer(br.readLine());
      int sx = Integer.parseInt(st.nextToken());
      int sy = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int ex = Integer.parseInt(st.nextToken());
      int ey = Integer.parseInt(st.nextToken());

      if (sx == ex && sy == ey) {
        sb.append(0).append("\n");
        continue;
      }

      boolean[][] visited = new boolean[l][l];
      int[][] dist = new int[l][l];

      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{sx, sy});
      visited[sx][sy] = true;

      while (!q.isEmpty()) {
        int[] cur = q.poll();
        int x = cur[0];
        int y = cur[1];

        for (int i = 0; i < 8; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
            visited[nx][ny] = true;
            dist[nx][ny] = dist[x][y] + 1;
            q.add(new int[]{nx, ny});

            if (nx == ex && ny == ey) {
              sb.append(dist[nx][ny]).append("\n");
              q.clear();
              break;
            }
          }
        }
      }
    }

    System.out.print(sb);
  }
}
