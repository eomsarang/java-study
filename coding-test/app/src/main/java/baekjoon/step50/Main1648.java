package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1648 {

  static final long MOD = 1_000_000_007;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());

    if (N % 2 == 1) {
      System.out.println(0);
      return;
    }

    long k = N / 2;

    if (k == 0) {
      System.out.println(1);
      return;
    }
    if (k == 1) {
      System.out.println(3);
      return;
    }

    long[][] base = {
        {4, MOD - 1}, // -1 -> MOD-1
        {1, 0}
    };

    long[][] res = matrixPow(base, k - 1);

    long f1 = 3; // f(1)
    long f0 = 1; // f(0)

    long answer = (res[0][0] * f1 + res[0][1] * f0) % MOD;
    System.out.println(answer);
  }

  static long[][] matrixPow(long[][] m, long exp) {
    long[][] result = {
        {1, 0},
        {0, 1}
    };

    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = multiply(result, m);
      }
      m = multiply(m, m);
      exp >>= 1;
    }

    return result;
  }

  static long[][] multiply(long[][] a, long[][] b) {
    long[][] r = new long[2][2];

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 2; k++) {
          r[i][j] = (r[i][j] + a[i][k] * b[k][j]) % MOD;
        }
      }
    }
    return r;
  }
}