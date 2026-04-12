package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13448 {

  static class Problem {

    int M, P, R;

    Problem(int M, int P, int R) {
      this.M = M;
      this.P = P;
      this.R = R;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    int[] M = new int[N];
    int[] P = new int[N];
    int[] R = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      M[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      R[i] = Integer.parseInt(st.nextToken());
    }

    Problem[] arr = new Problem[N];
    for (int i = 0; i < N; i++) {
      arr[i] = new Problem(M[i], P[i], R[i]);
    }

    Arrays.sort(arr, (a, b) -> {
      return Long.compare((long) b.P * a.R, (long) a.P * b.R);
    });

    long[] dp = new long[T + 1];
    Arrays.fill(dp, 0);

    for (Problem p : arr) {
      for (int t = T; t >= p.R; t--) {
        long score = p.M - (long) t * p.P;
        dp[t] = Math.max(dp[t], dp[t - p.R] + score);
      }
    }

    long ans = 0;
    for (int t = 0; t <= T; t++) {
      ans = Math.max(ans, dp[t]);
    }

    System.out.println(ans);
  }
}