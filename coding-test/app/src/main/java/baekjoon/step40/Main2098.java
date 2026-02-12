package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2098 {

  static int N;
  static int[][] W;
  static int[][] dp;
  static final int INF = 1_000_000_000;

  static int tsp(int mask, int cur) {

    if (mask == (1 << N) - 1) {
      if (W[cur][0] == 0) {
        return INF;
      }
      return W[cur][0];
    }

    if (dp[mask][cur] != -1) {
      return dp[mask][cur];
    }

    dp[mask][cur] = INF;

    for (int next = 0; next < N; next++) {
      if ((mask & (1 << next)) == 0 && W[cur][next] != 0) {
        int cost = W[cur][next] +
            tsp(mask | (1 << next), next);
        dp[mask][cur] = Math.min(dp[mask][cur], cost);
      }
    }

    return dp[mask][cur];
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    W = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        W[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new int[1 << N][N];
    for (int i = 0; i < (1 << N); i++) {
      Arrays.fill(dp[i], -1);
    }

    System.out.println(tsp(1, 0));
  }
}
