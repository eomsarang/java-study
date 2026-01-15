package baekjoon.step35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472 {

  static int N, M;
  static int[][] map;
  static int[][] island;
  static boolean[][] visited;
  static int islandCount = 0;

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static class Edge implements Comparable<Edge> {

    int a, b, len;

    Edge(int a, int b, int len) {
      this.a = a;
      this.b = b;
      this.len = len;
    }

    public int compareTo(Edge o) {
      return this.len - o.len;
    }
  }

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static boolean union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
      return false;
    }
    parent[b] = a;
    return true;
  }

  static void bfs(int sx, int sy) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sx, sy});
    island[sx][sy] = islandCount;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int d = 0; d < 4; d++) {
        int nx = cur[0] + dx[d];
        int ny = cur[1] + dy[d];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
          continue;
        }
        if (map[nx][ny] == 1 && island[nx][ny] == 0) {
          island[nx][ny] = islandCount;
          q.add(new int[]{nx, ny});
        }
      }
    }
  }

  static List<Edge> findBridges() {
    List<Edge> edges = new ArrayList<>();

    for (int x = 0; x < N; x++) {
      for (int y = 0; y < M; y++) {
        if (island[x][y] > 0) {
          int from = island[x][y];

          for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            int len = 0;

            while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
              if (island[nx][ny] == from) {
                break;
              }

              if (island[nx][ny] > 0) {
                if (len >= 2) {
                  edges.add(new Edge(from, island[nx][ny], len));
                }
                break;
              }

              nx += dx[d];
              ny += dy[d];
              len++;
            }
          }
        }
      }
    }
    return edges;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    island = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 1️⃣ 섬 번호 매기기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1 && island[i][j] == 0) {
          islandCount++;
          bfs(i, j);
        }
      }
    }

    List<Edge> edges = findBridges();
    Collections.sort(edges);

    parent = new int[islandCount + 1];
    for (int i = 1; i <= islandCount; i++) {
      parent[i] = i;
    }

    // 3️⃣ MST
    int total = 0;
    int used = 0;

    for (Edge e : edges) {
      if (union(e.a, e.b)) {
        total += e.len;
        used++;
      }
    }

    if (used != islandCount - 1) {
      System.out.println(-1);
    } else {
      System.out.println(total);
    }
  }
}
