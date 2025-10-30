package baekjoon.step24;

import java.util.Scanner;

public class Main2630 {

  static int[][] paper;
  static int white = 0;
  static int blue = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    paper = new int[N][N];

    // 입력 받기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        paper[i][j] = sc.nextInt();
      }
    }

    divide(0, 0, N);

    System.out.println(white);
    System.out.println(blue);
  }

  // 분할 정복 함수
  static void divide(int x, int y, int size) {
    if (checkColor(x, y, size)) {
      if (paper[x][y] == 0) {
        white++;
      } else {
        blue++;
      }
      return;
    }

    int newSize = size / 2;
    divide(x, y, newSize);
    divide(x, y + newSize, newSize);
    divide(x + newSize, y, newSize);
    divide(x + newSize, y + newSize, newSize); // 4사분면
  }

  static boolean checkColor(int x, int y, int size) {
    int color = paper[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (paper[i][j] != color) {
          return false;
        }
      }
    }
    return true;
  }
}
