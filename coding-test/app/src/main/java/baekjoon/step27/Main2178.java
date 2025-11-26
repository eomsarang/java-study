package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

  static int N, M;
  static int[][] map;
  static boolean[][] visited;
  static int[][] dist;

  // 상하좌우
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];
    dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    bfs(0, 0);

    System.out.println(dist[N - 1][M - 1]);
  }

  static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;
    dist[x][y] = 1;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0];
      int cy = cur[1];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
          continue;
        }

        if (map[nx][ny] == 0 || visited[nx][ny]) {
          continue;
        }

        visited[nx][ny] = true;
        dist[nx][ny] = dist[cx][cy] + 1;
        queue.add(new int[]{nx, ny});
      }
    }
  }
}
