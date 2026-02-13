package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17404 {

  static final int INF = 1_000_000_000;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] cost = new int[N][3];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      cost[i][0] = Integer.parseInt(st.nextToken());
      cost[i][1] = Integer.parseInt(st.nextToken());
      cost[i][2] = Integer.parseInt(st.nextToken());
    }

    int answer = INF;

    for (int start = 0; start < 3; start++) {

      int[][] dp = new int[N][3];

      for (int c = 0; c < 3; c++) {
        if (c == start) {
          dp[0][c] = cost[0][c];
        } else {
          dp[0][c] = INF;
        }
      }

      for (int i = 1; i < N; i++) {
        dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
      }

      for (int last = 0; last < 3; last++) {
        if (last != start) {
          answer = Math.min(answer, dp[N - 1][last]);
        }
      }
    }

    System.out.println(answer);
  }
}
