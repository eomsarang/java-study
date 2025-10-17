package baekjoon.step21;

import java.util.Arrays;
import java.util.Scanner;

public class Main2656 {


  public class Main {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      int[][] wire = new int[n][2];
      for (int i = 0; i < n; i++) {
        wire[i][0] = sc.nextInt();
        wire[i][1] = sc.nextInt();
      }

      Arrays.sort(wire, (a, b) -> a[0] - b[0]);

      int[] dp = new int[n];
      Arrays.fill(dp, 1);

      int maxLIS = 1;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (wire[j][1] < wire[i][1]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
        maxLIS = Math.max(maxLIS, dp[i]);
      }

      System.out.println(n - maxLIS);
    }
  }
}
