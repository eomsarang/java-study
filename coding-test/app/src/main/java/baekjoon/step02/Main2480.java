package baekjoon.step02;

import java.util.Scanner;

public class Main2480 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if (a == b && b == c) {
      System.out.print(10000 + (a * 1000));
    }
    if (a == b && a != c) {
      System.out.print(1000 + (a * 100));
    }
    if (a == c && a != b) {
      System.out.print(1000 + (a * 100));
    }
    if (b == c && b != a) {
      System.out.print(1000 + (b * 100));
    }
    if ((a != b) && (b != c) && (a != c)) {
      if (a > b && ((b > c) || (c > b))) {
        System.out.print(a * 100);
      } else if (b > a && ((a > c) || (c > a))) {
        System.out.print(b * 100);
      }
    } else if (c > b && ((b > a) || (a > b))) {
      System.out.print(c * 100);
    }

  }
}
