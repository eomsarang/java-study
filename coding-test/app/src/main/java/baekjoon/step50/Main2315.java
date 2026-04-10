package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2315 {

  static int N, M;
  static int[] pos;
  static long[] w, prefix;
  static long[][][] dp;
  static final long INF = Long.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    pos = new int[N + 1];
    w = new long[N + 1];
    prefix = new long[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      pos[i] = Integer.parseInt(st.nextToken());
      w[i] = Long.parseLong(st.nextToken());
      prefix[i] = prefix[i - 1] + w[i];
    }

    dp = new long[N + 2][N + 2][2];

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= N; j++) {
        Arrays.fill(dp[i][j], INF);
      }
    }

    dp[M][M][0] = 0;
    dp[M][M][1] = 0;

    for (int len = 1; len <= N; len++) {
      for (int l = 1; l + len - 1 <= N; l++) {
        int r = l + len - 1;

        for (int dir = 0; dir < 2; dir++) {
          if (dp[l][r][dir] == INF) {
            continue;
          }

          long remain = prefix[N] - (prefix[r] - prefix[l - 1]);

          // 왼쪽 확장
          if (l > 1) {
            long dist;
            if (dir == 0) {
              dist = pos[l] - pos[l - 1];
            } else {
              dist = pos[r] - pos[l - 1];
            }

            dp[l - 1][r][0] = Math.min(
                dp[l - 1][r][0],
                dp[l][r][dir] + dist * remain
            );
          }

          // 오른쪽 확장
          if (r < N) {
            long dist;
            if (dir == 0) {
              dist = pos[r + 1] - pos[l];
            } else {
              dist = pos[r + 1] - pos[r];
            }

            dp[l][r + 1][1] = Math.min(
                dp[l][r + 1][1],
                dp[l][r][dir] + dist * remain
            );
          }
        }
      }
    }

    System.out.println(Math.min(dp[1][N][0], dp[1][N][1]));
  }
}