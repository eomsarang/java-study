package baekjoon.step21;

import java.util.Scanner;

public class Main1932 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[][] triangle = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = sc.nextInt();
      }
    }

    int[] dp = new int[n];
    dp[0] = triangle[0][0];

    for (int i = 1; i < n; i++) {
      // 뒤에서부터 갱신 (덮어쓰기 방지)
      for (int j = i; j >= 0; j--) {
        if (j == 0) {
          dp[j] = dp[j] + triangle[i][j];
        } else if (j == i) {
          dp[j] = dp[j - 1] + triangle[i][j];
        } else {
          dp[j] = Math.max(dp[j - 1], dp[j]) + triangle[i][j];
        }
      }
    }

    int max = 0;
    for (int val : dp) {
      max = Math.max(max, val);
    }
    System.out.println(max);
  }
}
