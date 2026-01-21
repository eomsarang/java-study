package baekjoon.step36;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2213 {

  static int n;
  static int[] w;
  static ArrayList<Integer>[] tree;
  static int[][] dp;
  static boolean[] visited;
  static ArrayList<Integer> result = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    w = new int[n + 1];
    dp = new int[n + 1][2];
    visited = new boolean[n + 1];

    tree = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      w[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      tree[u].add(v);
      tree[v].add(u);
    }

    dfs(1);

    if (dp[1][1] > dp[1][0]) {
      trace(1, 0, true);
      System.out.println(dp[1][1]);
    } else {
      trace(1, 0, false);
      System.out.println(dp[1][0]);
    }

    Collections.sort(result);
    StringBuilder sb = new StringBuilder();
    for (int x : result) {
      sb.append(x).append(" ");
    }
    System.out.println(sb.toString().trim());
  }

  static void dfs(int u) {
    visited[u] = true;
    dp[u][1] = w[u];
    dp[u][0] = 0;

    for (int v : tree[u]) {
      if (!visited[v]) {
        dfs(v);
        dp[u][1] += dp[v][0];
        dp[u][0] += Math.max(dp[v][0], dp[v][1]);
      }
    }
  }

  static void trace(int u, int parent, boolean selected) {
    if (selected) {
      result.add(u);
    }

    for (int v : tree[u]) {
      if (v == parent) {
        continue;
      }

      if (selected) {
        trace(v, u, false);
      } else {
        trace(v, u, dp[v][1] > dp[v][0]);
      }
    }
  }
}
