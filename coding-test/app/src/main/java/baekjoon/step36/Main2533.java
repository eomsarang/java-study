package baekjoon.step36;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2533 {

  static int N;
  static ArrayList<Integer>[] tree;
  static int[][] dp;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    tree = new ArrayList[N + 1];
    dp = new int[N + 1][2];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      tree[u].add(v);
      tree[v].add(u);
    }

    dfs(1);

    System.out.println(Math.min(dp[1][0], dp[1][1]));
  }

  static void dfs(int u) {
    visited[u] = true;
    dp[u][0] = 0;
    dp[u][1] = 1;

    for (int v : tree[u]) {
      if (!visited[v]) {
        dfs(v);
        dp[u][0] += dp[v][1];
        dp[u][1] += Math.min(dp[v][0], dp[v][1]);
      }
    }
  }
}
