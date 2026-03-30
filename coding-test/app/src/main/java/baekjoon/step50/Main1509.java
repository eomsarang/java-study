package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1509 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int n = s.length();

    boolean[][] isPal = new boolean[n][n];

    // 길이 1
    for (int i = 0; i < n; i++) {
      isPal[i][i] = true;
    }

    // 길이 2 이상
    for (int len = 2; len <= n; len++) {
      for (int i = 0; i + len - 1 < n; i++) {
        int j = i + len - 1;

        if (s.charAt(i) == s.charAt(j)) {
          if (len == 2 || isPal[i + 1][j - 1]) {
            isPal[i][j] = true;
          }
        }
      }
    }

    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = Integer.MAX_VALUE;

      for (int j = 0; j <= i; j++) {
        if (isPal[j][i]) {
          if (j == 0) {
            dp[i] = 1;
          } else {
            dp[i] = Math.min(dp[i], dp[j - 1] + 1);
          }
        }
      }
    }

    System.out.println(dp[n - 1]);
  }
}