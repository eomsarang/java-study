package baekjoon.step31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2629 {

  static int N;
  static int[] weights;
  static boolean[][] dp;
  static final int MAX = 15000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    weights = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
    }

    dp = new boolean[N + 1][MAX + 1];
    dp[0][0] = true;

    for (int i = 1; i <= N; i++) {
      int w = weights[i - 1];
      for (int diff = 0; diff <= MAX; diff++) {
        if (!dp[i - 1][diff]) {
          continue;
        }

        dp[i][diff] = true;

        if (diff + w <= MAX) {
          dp[i][diff + w] = true;
        }

        dp[i][Math.abs(diff - w)] = true;
      }
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      int bead = Integer.parseInt(st.nextToken());
      if (bead <= MAX && dp[N][bead]) {
        sb.append("Y ");
      } else {
        sb.append("N ");
      }
    }

    System.out.println(sb.toString().trim());
  }
}
