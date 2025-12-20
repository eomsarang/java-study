package baekjoon.step31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11062 {

  static int[] card;
  static int[][] dp;
  static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      card = new int[N];
      dp = new int[N][N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        card[i] = Integer.parseInt(st.nextToken());
      }

      for (int len = 1; len <= N; len++) {
        for (int l = 0; l + len - 1 < N; l++) {
          int r = l + len - 1;
          int used = N - len;

          if (used % 2 == 0) { // 근우 턴
            if (l == r) {
              dp[l][r] = card[l];
            } else {
              dp[l][r] = Math.max(
                  card[l] + dp[l + 1][r],
                  card[r] + dp[l][r - 1]
              );
            }
          } else { // 명우 턴
            if (l == r) {
              dp[l][r] = 0;
            } else {
              dp[l][r] = Math.min(
                  dp[l + 1][r],
                  dp[l][r - 1]
              );
            }
          }
        }
      }

      sb.append(dp[0][N - 1]).append('\n');
    }

    System.out.print(sb);
  }
}
