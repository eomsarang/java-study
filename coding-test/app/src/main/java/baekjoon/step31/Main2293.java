package baekjoon.step31;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2293 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] first = br.readLine().split(" ");
    int n = Integer.parseInt(first[0]);
    int k = Integer.parseInt(first[1]);

    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[k + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int i = coin; i <= k; i++) {
        dp[i] += dp[i - coin];
      }
    }

    System.out.println(dp[k]);
  }
}
