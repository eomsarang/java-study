package baekjoon.step47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11438 {

  static int N, M;
  static ArrayList<Integer>[] tree;
  static int[][] parent;
  static int[] depth;
  static int LOG;

  static void dfs(int node, int par, int d) {
    parent[0][node] = par;
    depth[node] = d;

    for (int next : tree[node]) {
      if (next == par) {
        continue;
      }
      dfs(next, node, d + 1);
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

      tree[u].add(v);
      tree[v].add(u);
    }

    LOG = 17;
    while ((1 << LOG) <= N) {
      LOG++;
    }

    parent = new int[LOG][N + 1];
    depth = new int[N + 1];

    dfs(1, 0, 0);

    // parent 테이블 채우기
    for (int k = 1; k < LOG; k++) {
      for (int i = 1; i <= N; i++) {
        parent[k][i] = parent[k - 1][parent[k - 1][i]];
      }
    }

    M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(lca(a, b)).append('\n');
    }

    System.out.print(sb);
  }
}
