package baekjoon.step17;

import java.util.Scanner;

public class Main1010 {

  public static long combination(int n, int r) {
    if (r > n - r) {
      r = n - r;
    }
    long result = 1;
    for (int i = 1; i <= r; i++) {
      result = result * (n - i + 1) / i;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      System.out.println(combination(M, N));
    }
    sc.close();
  }
}
