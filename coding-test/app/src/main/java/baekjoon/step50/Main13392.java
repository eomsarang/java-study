package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main13392 {

  static final int INF = 1_000_000_000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    char[] A = br.readLine().toCharArray();
    char[] B = br.readLine().toCharArray();

    int[][] dp = new int[N + 1][10];

    for (int i = 0; i <= N; i++) {
      Arrays.fill(dp[i], INF);
    }

    dp[0][0] = 0;

    for (int i = 0; i < N; i++) {
      int curNum = A[i] - '0';
      int target = B[i] - '0';

      for (int rot = 0; rot < 10; rot++) {
        if (dp[i][rot] == INF) {
          continue;
        }

        int cur = (curNum + rot) % 10;
        
        int left = (target - cur + 10) % 10;
        int nextRot = (rot + left) % 10;

        dp[i + 1][nextRot] = Math.min(
            dp[i + 1][nextRot],
            dp[i][rot] + left
        );

        int right = (cur - target + 10) % 10;

        dp[i + 1][rot] = Math.min(
            dp[i + 1][rot],
            dp[i][rot] + right
        );
      }
    }

    int answer = INF;
    for (int i = 0; i < 10; i++) {
      answer = Math.min(answer, dp[N][i]);
    }

    System.out.println(answer);
  }
}