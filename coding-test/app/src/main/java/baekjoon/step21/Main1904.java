package baekjoon.step21;

import java.util.Scanner;

public class Main1904 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    int MOD = 15746;
    int[] dp = new int[n + 2];

    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }

    System.out.println(dp[n]);
  }
}
