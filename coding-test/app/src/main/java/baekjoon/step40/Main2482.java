package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2482 {

  static final int MOD = 1_000_000_003;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    if (K > N / 2) {
      System.out.println(0);
      return;
    }

    long[][] dp = new long[N + 1][K + 1];

    for (int i = 0; i <= N; i++) {
      dp[i][0] = 1;
    }

    dp[1][1] = 1;

    for (int n = 2; n <= N; n++) {
      for (int k = 1; k <= K; k++) {
        dp[n][k] =
            (dp[n - 1][k] + dp[n - 2][k - 1]) % MOD;
      }
    }

    long ans = (dp[N - 1][K] + dp[N - 3][K - 1]) % MOD;

    System.out.println(ans);
  }
}
