package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2618 {

  static int N, W;
  static int[][] event;
  static int[][] dp;
  static int[][] trace;

  static int dist(int a, int b, int car) {
    int x1, y1;
    if (car == 1) {
      if (a == 0) {
        x1 = 1;
        y1 = 1;
      } else {
        x1 = event[a][0];
        y1 = event[a][1];
      }
    } else {
      if (b == 0) {
        x1 = N;
        y1 = N;
      } else {
        x1 = event[b][0];
        y1 = event[b][1];
      }
    }
    int x2 = event[Math.max(a, b) + 1][0];
    int y2 = event[Math.max(a, b) + 1][1];
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    W = Integer.parseInt(br.readLine());

    event = new int[W + 1][2];
    for (int i = 1; i <= W; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      event[i][0] = Integer.parseInt(st.nextToken());
      event[i][1] = Integer.parseInt(st.nextToken());
    }

    dp = new int[W + 1][W + 1];
    trace = new int[W + 1][W + 1];

    for (int[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    dp[0][0] = 0;

    for (int i = 0; i <= W; i++) {
      for (int j = 0; j <= W; j++) {
        if (dp[i][j] == Integer.MAX_VALUE) {
          continue;
        }
        int next = Math.max(i, j) + 1;
        if (next > W) {
          continue;
        }

        int cost1 = dp[i][j] + dist(i, j, 1);
        if (dp[next][j] > cost1) {
          dp[next][j] = cost1;
          trace[next][j] = 1;
        }

        int cost2 = dp[i][j] + dist(i, j, 2);
        if (dp[i][next] > cost2) {
          dp[i][next] = cost2;
          trace[i][next] = 2;
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int endI = 0, endJ = 0;
    for (int i = 0; i <= W; i++) {
      if (dp[i][W] < min) {
        min = dp[i][W];
        endI = i;
        endJ = W;
      }
      if (dp[W][i] < min) {
        min = dp[W][i];
        endI = W;
        endJ = i;
      }
    }

    System.out.println(min);

    int[] result = new int[W + 1];
    int i = endI, j = endJ;

    for (int k = W; k >= 1; k--) {
      int t = trace[i][j];
      result[k] = t;
      if (t == 1) {
        i--;
      } else {
        j--;
      }
    }

    for (int k = 1; k <= W; k++) {
      System.out.println(result[k]);
    }
  }
}
