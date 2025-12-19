package baekjoon.step31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7579 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] mem = new int[N];
    int[] cost = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      mem[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }

    int maxCost = 100 * N;
    int[] dp = new int[maxCost + 1];

    for (int i = 0; i < N; i++) {
      int m = mem[i];
      int c = cost[i];
      for (int j = maxCost; j >= c; j--) {
        dp[j] = Math.max(dp[j], dp[j - c] + m);
      }
    }

    for (int c = 0; c <= maxCost; c++) {
      if (dp[c] >= M) {
        System.out.println(c);
        break;
      }
    }
  }
}
