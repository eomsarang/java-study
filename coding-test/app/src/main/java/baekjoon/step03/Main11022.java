package baekjoon.step03;

import java.util.Scanner;

public class Main11022 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int[] arrA = new int[t];
    int[] arrB = new int[t];
    int[] arrC = new int[t];

    for (int i = 0; i < t; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (0 < a && b < 10) {
        arrA[i] += a;
        arrB[i] += b;
        arrC[i] += a + b;
      }
    }

    for (int i = 0; i < t; i++) {
      System.out.printf("Case #%d: %d + %d = %d\n", i + 1, arrA[i], arrB[i], arrC[i]);
    }

    sc.close();
  }
}
