package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012 {

  static int M, N, K;
  static int[][] field;
  static boolean[][] visited;

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      field = new int[N][M];
      visited = new boolean[N][M];

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        field[y][x] = 1;
      }

      int wormCount = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (field[i][j] == 1 && !visited[i][j]) {
            dfs(i, j);
            wormCount++;
          }
        }
      }

      System.out.println(wormCount);
    }
  }

  static void dfs(int y, int x) {
    visited[y][x] = true;

    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
        if (field[ny][nx] == 1 && !visited[ny][nx]) {
          dfs(ny, nx);
        }
      }
    }
  }
}
