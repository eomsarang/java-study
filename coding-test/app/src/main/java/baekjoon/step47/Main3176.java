package baekjoon.step47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3176 {

  static int N, K, LOG;
  static ArrayList<int[]>[] tree;
  static int[][] parent;
  static int[][] minEdge;
  static int[][] maxEdge;
  static int[] depth;

  static void dfs(int node, int par, int d) {
    depth[node] = d;

    for (int[] next : tree[node]) {
      int v = next[0];
      int w = next[1];

      if (v == par) {
        continue;
      }

      parent[0][v] = node;
      minEdge[0][v] = w;
      maxEdge[0][v] = w;

      dfs(v, node, d + 1);
    }
  }

  static void lca(int a, int b, StringBuilder sb) {

    int minVal = Integer.MAX_VALUE;
    int maxVal = 0;

    if (depth[a] < depth[b]) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    for (int k = LOG - 1; k >= 0; k--) {
      if (depth[a] - (1 << k) >= depth[b]) {
        minVal = Math.min(minVal, minEdge[k][a]);
        maxVal = Math.max(maxVal, maxEdge[k][a]);
        a = parent[k][a];
      }
    }

    if (a == b) {
      sb.append(minVal).append(' ').append(maxVal).append('\n');
      return;
    }

    for (int k = LOG - 1; k >= 0; k--) {
      if (parent[k][a] != parent[k][b]) {
        minVal = Math.min(minVal, Math.min(minEdge[k][a], minEdge[k][b]));
        maxVal = Math.max(maxVal, Math.max(maxEdge[k][a], maxEdge[k][b]));

        a = parent[k][a];
        b = parent[k][b];
      }
    }

    minVal = Math.min(minVal, Math.min(minEdge[0][a], minEdge[0][b]));
    maxVal = Math.max(maxVal, Math.max(maxEdge[0][a], maxEdge[0][b]));

    sb.append(minVal).append(' ').append(maxVal).append('\n');
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
    minEdge = new int[LOG][N + 1];
    maxEdge = new int[LOG][N + 1];
    depth = new int[N + 1];

    for (int i = 0; i < LOG; i++) {
      Arrays.fill(minEdge[i], Integer.MAX_VALUE);
    }

    dfs(1, 0, 0);

    // DP
    for (int k = 1; k < LOG; k++) {
      for (int i = 1; i <= N; i++) {
        int p = parent[k - 1][i];

        parent[k][i] = parent[k - 1][p];
        minEdge[k][i] = Math.min(minEdge[k - 1][i], minEdge[k - 1][p]);
        maxEdge[k][i] = Math.max(maxEdge[k - 1][i], maxEdge[k - 1][p]);
      }
    }

    K = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      lca(a, b, sb);
    }

    System.out.print(sb);
  }
}
