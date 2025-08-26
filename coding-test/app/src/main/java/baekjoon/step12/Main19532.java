package baekjoon.step12;

import java.util.Scanner;

public class Main19532 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    int d = sc.nextInt(), e = sc.nextInt(), f = sc.nextInt();

    int det = a * e - b * d;
    int x = (c * e - b * f) / det;
    int y = (a * f - c * d) / det;

    System.out.println(x + " " + y);
    sc.close();
  }
}
