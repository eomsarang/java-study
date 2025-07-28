package baekjoon.step03;

import java.util.Scanner;

public class Main11021 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int[] arr = new int[t];

    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (0 < a && b < 10) {
        arr[i] = a + b;
      }
    }

    for (int i = 0; i < t; i++) {
      System.out.printf("Case #%d: %d\n", i + 1, arr[i]);
    }

    sc.close();

  }
}
