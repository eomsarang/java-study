package baekjoon.step24;

import java.util.Scanner;

public class Main1992 {

  static int[][] video;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    video = new int[N][N];

    for (int i = 0; i < N; i++) {
      String line = sc.next();
      for (int j = 0; j < N; j++) {
        video[i][j] = line.charAt(j) - '0';
      }
    }

    compress(0, 0, N);
    System.out.println(sb);
  }

  static void compress(int x, int y, int size) {
    if (checkSame(x, y, size)) {
      sb.append(video[x][y]);
      return;
    }

    int newSize = size / 2;
    sb.append("(");

    compress(x, y, newSize);
    compress(x, y + newSize, newSize);
    compress(x + newSize, y, newSize);
    compress(x + newSize, y + newSize, newSize);

    sb.append(")");
  }

  static boolean checkSame(int x, int y, int size) {
    int color = video[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (video[i][j] != color) {
          return false;
        }
      }
    }
    return true;
  }
}
