package baekjoon.step07;

import java.util.Scanner;

public class Main2563 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[][] paper = new boolean[100][100];
    int area = 0;

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      for (int r = x; r < x + 10; r++) {
        for (int c = y; c < y + 10; c++) {
          if (!paper[r][c]) {
            paper[r][c] = true;
            area++;
          }
        }
      }
    }

    System.out.println(area);
  }
}
