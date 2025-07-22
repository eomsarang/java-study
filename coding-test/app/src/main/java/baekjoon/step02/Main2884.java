package baekjoon.step02;

import java.util.Scanner;

public class Main2884 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int m = sc.nextInt();

    if ((0 <= h && h <= 23) && (0 <= m && m <= 59)) {
      if (0 < h && h <= 23) {
        if (45 <= m && m <= 59) {
          System.out.printf("%d %d", h, m - 45);
        } else if (0 <= m && m < 45) {
          System.out.printf("%d %d", h - 1, m - 45 + 60);
        }
      } else if (h == 0) {
        if (45 <= m && m <= 59) {
          System.out.printf("%d %d", h, m - 45);
        } else if (0 <= m && m < 45) {
          System.out.printf("%d %d", 23, m - 45 + 60);
        }
      }
    }

    sc.close();
  }
}
