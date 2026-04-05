package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2494 {

  static int N;
  static int[] A, B;
  static int[][] dp;
  static int[][] choice;
  static int[][] prev;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    String s1 = br.readLine();
    String s2 = br.readLine();

    A = new int[N];
    B = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = s1.charAt(i) - '0';
      B[i] = s2.charAt(i) - '0';
    }

    dp = new int[N + 1][10];
    choice = new int[N + 1][10];
    prev = new int[N + 1][10];

    for (int i = 0; i <= N; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    dp[0][0] = 0;

    for (int i = 0; i < N; i++) {
      for (int rot = 0; rot < 10; rot++) {
        if (dp[i][rot] == Integer.MAX_VALUE) {
          continue;
        }

        int cur = (A[i] + rot) % 10;

        int left = (B[i] - cur + 10) % 10;
        int nextRot = (rot + left) % 10;

        if (dp[i + 1][nextRot] > dp[i][rot] + left) {
          dp[i + 1][nextRot] = dp[i][rot] + left;
          choice[i + 1][nextRot] = left;
          prev[i + 1][nextRot] = rot;
        }

        int right = (cur - B[i] + 10) % 10;

        if (dp[i + 1][rot] > dp[i][rot] + right) {
          dp[i + 1][rot] = dp[i][rot] + right;
          choice[i + 1][rot] = -right;
          prev[i + 1][rot] = rot;
        }
      }
    }

    int ans = Integer.MAX_VALUE;
    int lastRot = 0;

    for (int rot = 0; rot < 10; rot++) {
      if (dp[N][rot] < ans) {
        ans = dp[N][rot];
        lastRot = rot;
      }
    }

    int[] result = new int[N];
    int rot = lastRot;

    for (int i = N; i > 0; i--) {
      int c = choice[i][rot];
      result[i - 1] = c;
      rot = prev[i][rot];
    }

    StringBuilder sb = new StringBuilder();
    sb.append(ans).append("\n");

    for (int i = 0; i < N; i++) {
      if (result[i] != 0) {
        sb.append(i + 1).append(" ").append(result[i]).append("\n");
      }
    }

    System.out.print(sb);
  }
}