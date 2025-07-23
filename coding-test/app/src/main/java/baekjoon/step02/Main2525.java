package baekjoon.step02;

import java.util.Scanner;

public class Main2525 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if ((0 <= a && a <= 23) && (0 <= b && b <= 59) && (0 <= c && c <= 1000)) {
      if (a + (c / 60) < 23) {
        if (b + (c % 60) < 60) {
          System.out.printf("%d %d", a + (c / 60), b + (c % 60));
        } else if (b + c >= 60) {
          System.out.printf("%d %d", a + (c / 60) + 1, b + (c % 60) - 60);
        }
      } else if (a + (c / 60) == 23) {
        if (b + (c % 60) < 60) {
          System.out.printf("%d %d", 23, b + (c % 60));
        } else if (b + c >= 60) {
          System.out.printf("%d %d", 0, b + (c % 60) - 60);
        }
      } else if (a + (c / 60) > 23) {
        if (b + (c % 60) < 60) {
          System.out.printf("%d %d", (a + (c / 60)) % 24, b + (c % 60));
        } else if (b + c >= 60) {
          System.out.printf("%d %d", (a + (c / 60)) % 24 + 1, b + (c % 60) - 60);
        }
      }
    }
  }
}