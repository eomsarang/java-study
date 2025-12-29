package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main11780 {

  static final int INF = 1_000_000_000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] dist = new int[n + 1][n + 1];
    int[][] next = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (dist[a][b] > c) {
        dist[a][b] = c;
        next[a][b] = b;
      }
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            next[i][j] = next[i][k];
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[i][j] == INF) {
          sb.append("0 ");
        } else {
          sb.append(dist[i][j]).append(" ");
        }
      }
      sb.append('\n');
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {

        if (i == j || next[i][j] == 0) {
          sb.append("0\n");
          continue;
        }

        List<Integer> path = new ArrayList<>();
        int cur = i;

        while (cur != j) {
          path.add(cur);
          cur = next[cur][j];
        }
        path.add(j);

        sb.append(path.size()).append(' ');
        for (int city : path) {
          sb.append(city).append(' ');
        }
        sb.append('\n');
      }
    }

    System.out.print(sb);
  }
}
