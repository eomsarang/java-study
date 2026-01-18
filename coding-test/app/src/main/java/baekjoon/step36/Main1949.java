package baekjoon.step36;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1949 {

  static int N;
  static int[] people;
  static List<Integer>[] tree;
  static int[][] dp;
  static boolean[] visited;

  static void dfs(int u) {
    visited[u] = true;
    dp[u][1] = people[u];

    int sum = 0;
    int minDiff = Integer.MAX_VALUE;
    boolean hasExcellent = false;

    for (int v : tree[u]) {
      if (!visited[v]) {
        dfs(v);

        dp[u][1] += dp[v][0];

        sum += Math.max(dp[v][0], dp[v][1]);

        if (dp[v][1] >= dp[v][0]) {
          hasExcellent = true;
        } else {
          minDiff = Math.min(minDiff, dp[v][0] - dp[v][1]);
        }
      }
    }

    if (!hasExcellent && minDiff != Integer.MAX_VALUE) {
      sum -= minDiff;
    }

    dp[u][0] = sum;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    people = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      people[i] = Integer.parseInt(st.nextToken());
    }

    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      tree[a].add(b);
      tree[b].add(a);
    }

    dp = new int[N + 1][2];
    visited = new boolean[N + 1];

    dfs(1);

    System.out.println(Math.max(dp[1][0], dp[1][1]));
  }
}
