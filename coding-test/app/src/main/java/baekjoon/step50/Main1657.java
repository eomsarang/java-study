package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1657 {

  static int N, M;
  static int[][] dp;
  static int[][] score = {
      {10, 8, 7, 5, 1},
      {8, 6, 4, 3, 1},
      {7, 4, 3, 2, 1},
      {5, 3, 2, 2, 1},
      {1, 1, 1, 1, 0}
  };
  static int[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = convert(s.charAt(j));
      }
    }

    dp = new int[N * M + 1][1 << M];
    for (int i = 0; i <= N * M; i++) {
      Arrays.fill(dp[i], -1);
    }

    System.out.println(solve(0, 0));
  }

  static int solve(int pos, int mask) {
    if (pos == N * M) {
      return 0;
    }

    if (dp[pos][mask] != -1) {
      return dp[pos][mask];
    }

    int r = pos / M;
    int c = pos % M;

    int result = 0;

    if ((mask & 1) != 0) {
      result = solve(pos + 1, mask >> 1);
    } else {

      result = solve(pos + 1, mask >> 1);

      if (r + 1 < N) {
        int val = score[board[r][c]][board[r + 1][c]];
        result = Math.max(result,
            solve(pos + 1, (mask >> 1) | (1 << (M - 1))) + val);
      }

      if (c + 1 < M && (mask & 2) == 0) {
        int val = score[board[r][c]][board[r][c + 1]];
        result = Math.max(result,
            solve(pos + 2, mask >> 2) + val);
      }
    }

    return dp[pos][mask] = result;
  }

  static int convert(char ch) {
    if (ch == 'A') {
      return 0;
    }
    if (ch == 'B') {
      return 1;
    }
    if (ch == 'C') {
      return 2;
    }
    if (ch == 'D') {
      return 3;
    }
    return 4;
  }
}