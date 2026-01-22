package baekjoon.step36;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15647 {

  static class Edge {

    int to, w;

    Edge(int t, int w) {
      this.to = t;
      this.w = w;
    }
  }

  static int N;
  static ArrayList<Edge>[] g;
  static long[] dist;
  static long[] ans;
  static int[] cnt;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    g = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      g[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      g[u].add(new Edge(v, d));
      g[v].add(new Edge(u, d));
    }

    dist = new long[N + 1];
    ans = new long[N + 1];
    cnt = new int[N + 1];

    dfs1(1, 0);
    ans[1] = dist[1];
    dfs2(1, 0);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(ans[i]).append('\n');
    }
    System.out.print(sb);
  }

  static void dfs1(int u, int p) {
    cnt[u] = 1;
    for (Edge e : g[u]) {
      if (e.to == p) {
        continue;
      }
      dfs1(e.to, u);
      cnt[u] += cnt[e.to];
      dist[u] += dist[e.to] + (long) cnt[e.to] * e.w;
    }
  }

  static void dfs2(int u, int p) {
    for (Edge e : g[u]) {
      if (e.to == p) {
        continue;
      }
      ans[e.to] = ans[u]
          - (long) cnt[e.to] * e.w
          + (long) (N - cnt[e.to]) * e.w;
      dfs2(e.to, u);
    }
  }
}
