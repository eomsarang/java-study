package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {

  static int N, M;
  static int[][] map;
  static boolean[][][] visited;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static class Node {

    int x, y, broken, dist;

    Node(int x, int y, int broken, int dist) {
      this.x = x;
      this.y = y;
      this.broken = broken;
      this.dist = dist;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M][2];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs());
  }

  static int bfs() {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 0, 1));
    visited[0][0][0] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == N - 1 && cur.y == M - 1) {
        return cur.dist;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
          continue;
        }

        if (map[nx][ny] == 0) {
          if (!visited[nx][ny][cur.broken]) {
            visited[nx][ny][cur.broken] = true;
            q.add(new Node(nx, ny, cur.broken, cur.dist + 1));
          }
        } else {
          if (cur.broken == 0 && !visited[nx][ny][1]) {
            visited[nx][ny][1] = true;
            q.add(new Node(nx, ny, 1, cur.dist + 1));
          }
        }
      }
    }

    return -1;
  }
}
