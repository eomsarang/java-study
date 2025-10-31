package baekjoon.step24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1780 {

  static int[][] paper;
  static int[] count = new int[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    divide(0, 0, N);

    System.out.println(count[0]);
    System.out.println(count[1]);
    System.out.println(count[2]);
  }

  static void divide(int r, int c, int size) {
    if (checkSame(r, c, size)) {
      count[paper[r][c] + 1]++;
      return;
    }

    int newSize = size / 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        divide(r + i * newSize, c + j * newSize, newSize);
      }
    }
  }

  static boolean checkSame(int r, int c, int size) {
    int first = paper[r][c];
    for (int i = r; i < r + size; i++) {
      for (int j = c; j < c + size; j++) {
        if (paper[i][j] != first) {
          return false;
        }
      }
    }
    return true;
  }
}
