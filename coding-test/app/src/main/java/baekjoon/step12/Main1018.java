package baekjoon.step12;

import java.util.Scanner;

public class Main1018 {

  static char[][] board;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    board = new char[N][M];
    for (int i = 0; i < N; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        int cnt = getMinRepaint(i, j);
        result = Math.min(result, cnt);
      }
    }

    System.out.println(result);
  }

  private static int getMinRepaint(int startX, int startY) {
    int countW = 0;
    int countB = 0;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char current = board[startX + i][startY + j];

        if ((i + j) % 2 == 0) {
          if (current != 'W') {
            countW++;
          }
          if (current != 'B') {
            countB++;
          }
        } else {
          if (current != 'B') {
            countW++;
          }
          if (current != 'W') {
            countB++;
          }
        }
      }
    }

    return Math.min(countW, countB);
  }
}
