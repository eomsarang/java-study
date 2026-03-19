package baekjoon.step47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13511 {

  static int N, M, LOG;
  static ArrayList<int[]>[] tree;
  static int[][] parent;
  static int[] depth;
  static long[] dist;

  static void dfs(int node, int par, int d) {
    depth[node] = d;

    for (int[] next : tree[node]) {
      int v = next[0];
      int w = next[1];

      if (v == par) {
        continue;
      }

      parent[0][v] = node;
      dist[v] = dist[node] + w;

      dfs(v, node, d + 1);
    }
  }

  static int lca(int a, int b) {

    if (depth[a] < depth[b]) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    for (int k = LOG - 1; k >= 0; k--) {
      if (depth[a] - (1 << k) >= depth[b]) {
        a = parent[k][a];
      }
    }

    if (a == b) {
      return a;
    }

    for (int k = LOG - 1; k >= 0; k--) {
      if (parent[k][a] != parent[k][b]) {
        a = parent[k][a];
        b = parent[k][b];
      }
    }

    return parent[0][a];
  }

  static int jump(int node, int k) {
    for (int i = 0; i < LOG; i++) {
      if ((k & (1 << i)) != 0) {
        node = parent[i][node];
      }
    }
    return node;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      tree[u].add(new int[]{v, w});
      tree[v].add(new int[]{u, w});
    }

    LOG = 17;
    while ((1 << LOG) <= N) {
      LOG++;
    }

    parent = new int[LOG][N + 1];
    depth = new int[N + 1];
    dist = new long[N + 1];

    dfs(1, 0, 0);

    for (int k = 1; k < LOG; k++) {
      for (int i = 1; i <= N; i++) {
        parent[k][i] = parent[k - 1][parent[k - 1][i]];
      }
    }

    M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {

      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int l = lca(u, v);

        long ans = dist[u] + dist[v] - 2 * dist[l];
        sb.append(ans).append('\n');

      } else {

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int l = lca(u, v);

        int up = depth[u] - depth[l] + 1;

        if (k <= up) {
          sb.append(jump(u, k - 1)).append('\n');
        } else {
          int down = k - up;
          int distDown = depth[v] - depth[l];
          sb.append(jump(v, distDown - down)).append('\n');
        }
      }
    }

    System.out.print(sb);
  }
}
