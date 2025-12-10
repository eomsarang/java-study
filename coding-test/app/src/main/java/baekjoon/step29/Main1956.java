package baekjoon.step29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1956 {

  static final int INF = 1_000_000_000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    int[][] dist = new int[V + 1][V + 1];

    for (int i = 1; i <= V; i++) {
      Arrays.fill(dist[i], INF);
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      dist[a][b] = c;
    }

    for (int k = 1; k <= V; k++) {
      for (int i = 1; i <= V; i++) {
        for (int j = 1; j <= V; j++) {
          if (dist[i][j] > dist[i][k] + dist[k][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }

    int answer = INF;

    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        if (i == j) {
          continue;
        }
        if (dist[i][j] != INF && dist[j][i] != INF) {
          answer = Math.min(answer, dist[i][j] + dist[j][i]);
        }
      }
    }

    System.out.println(answer == INF ? -1 : answer);
  }
}
