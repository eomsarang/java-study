package baekjoon.step21;

import java.util.Scanner;

public class Main9416 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    long[] P = new long[101];
    P[1] = 1;
    P[2] = 1;
    P[3] = 1;
    for (int i = 4; i <= 100; i++) {
      P[i] = P[i - 1] + P[i - 5];
    }

    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      System.out.println(P[N]);
    }
    sc.close();
  }
}
