package baekjoon.step24;

import java.util.Scanner;

public class Main11444 {

  static final long MOD = 1000000007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();

    long[][] base = {{1, 1}, {1, 0}};
    long[][] result = matrixPower(base, n);

    System.out.println(result[0][1] % MOD);
  }

  static long[][] matrixPower(long[][] a, long n) {
    if (n == 1) {
      return a;
    }

    long[][] half = matrixPower(a, n / 2);
    long[][] halfSquared = multiply(half, half);

    if (n % 2 == 0) {
      return halfSquared;
    } else {
      return multiply(halfSquared, a);
    }
  }

  static long[][] multiply(long[][] m1, long[][] m2) {
    long[][] res = new long[2][2];
    res[0][0] = (m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD;
    res[0][1] = (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD;
    res[1][0] = (m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD;
    res[1][1] = (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD;
    return res;
  }
}
