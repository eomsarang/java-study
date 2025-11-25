package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main2667 {

  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int count;

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }

    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          count = 0;
          dfs(i, j);
          result.add(count);
        }
      }
    }

    Collections.sort(result);

    System.out.println(result.size());
    for (int r : result) {
      System.out.println(r);
    }
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
        if (map[nx][ny] == 1 && !visited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }
}
