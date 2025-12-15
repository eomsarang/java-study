package baekjoon.step31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11066 {

  static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      int K = Integer.parseInt(br.readLine());
      int[] a = new int[K + 1];
      int[] prefix = new int[K + 1];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= K; i++) {
        a[i] = Integer.parseInt(st.nextToken());
        prefix[i] = prefix[i - 1] + a[i];
      }

      int[][] dp = new int[K + 1][K + 1];
      int[][] opt = new int[K + 1][K + 1];

      for (int i = 1; i <= K; i++) {
        opt[i][i] = i;
      }

      for (int len = 2; len <= K; len++) {
        for (int i = 1; i + len - 1 <= K; i++) {
          int j = i + len - 1;
          dp[i][j] = INF;

          for (int k = opt[i][j - 1]; k <= opt[i + 1][j]; k++) {
            int cost = dp[i][k] + dp[k + 1][j]
                + prefix[j] - prefix[i - 1];
            if (cost < dp[i][j]) {
              dp[i][j] = cost;
              opt[i][j] = k;
            }
          }
        }
      }

      sb.append(dp[1][K]).append('\n');
    }

    System.out.print(sb);
  }
}
