package baekjoon.step47;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17435 {

  static final int LOG = 19; // 2^19 > 500000

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int m = Integer.parseInt(br.readLine());

    int[][] dp = new int[LOG][m + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= m; i++) {
      dp[0][i] = Integer.parseInt(st.nextToken());
    }

    for (int k = 1; k < LOG; k++) {
      for (int i = 1; i <= m; i++) {
        dp[k][i] = dp[k - 1][dp[k - 1][i]];
      }
    }

    int Q = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (Q-- > 0) {
      st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      for (int k = 0; k < LOG; k++) {
        if ((n & (1 << k)) != 0) {
          x = dp[k][x];
        }
      }

      sb.append(x).append('\n');
    }

    System.out.print(sb);
  }
}
