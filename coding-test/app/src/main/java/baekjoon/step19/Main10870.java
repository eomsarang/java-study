package baekjoon.step19;

import java.util.Scanner;

public class Main10870 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    if (n == 0) {
      System.out.println(0);
      return;
    }

    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
      int temp = a + b;
      a = b;
      b = temp;
    }
    System.out.println(b);
  }
}
