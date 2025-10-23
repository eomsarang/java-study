package baekjoon.step22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main25682 {

  static int N, M, K;
  static int[][] whitePrefix, blackPrefix;
  static char[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    board = new char[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      String line = br.readLine();
      for (int j = 1; j <= M; j++) {
        board[i][j] = line.charAt(j - 1);
      }
    }

    whitePrefix = new int[N + 1][M + 1];
    blackPrefix = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        char expectedWhite = ((i + j) % 2 == 0) ? 'W' : 'B';
        char expectedBlack = ((i + j) % 2 == 0) ? 'B' : 'W';

        int whiteDiff = (board[i][j] == expectedWhite) ? 0 : 1;
        int blackDiff = (board[i][j] == expectedBlack) ? 0 : 1;

        whitePrefix[i][j] =
            whitePrefix[i - 1][j] + whitePrefix[i][j - 1] - whitePrefix[i - 1][j - 1] + whiteDiff;
        blackPrefix[i][j] =
            blackPrefix[i - 1][j] + blackPrefix[i][j - 1] - blackPrefix[i - 1][j - 1] + blackDiff;
      }
    }

    int result = Integer.MAX_VALUE;

    for (int i = K; i <= N; i++) {
      for (int j = K; j <= M; j++) {
        int whiteCount = getAreaSum(whitePrefix, i, j, K);
        int blackCount = getAreaSum(blackPrefix, i, j, K);
        result = Math.min(result, Math.min(whiteCount, blackCount));
      }
    }

    System.out.println(result);
  }

  static int getAreaSum(int[][] ps, int x, int y, int k) {
    return ps[x][y] - ps[x - k][y] - ps[x][y - k] + ps[x - k][y - k];
  }
}
