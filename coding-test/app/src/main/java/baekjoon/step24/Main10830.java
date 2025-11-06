package baekjoon.step24;

import java.util.Scanner;

public class Main10830 {

  static int N;
  static long B;
  static int[][] A;
  static final int MOD = 1000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    B = sc.nextLong();

    A = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        A[i][j] = sc.nextInt() % MOD;
      }
    }

    int[][] result = pow(A, B);

    // 출력
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(result[i][j] % MOD + " ");
      }
      System.out.println();
    }
  }

  static int[][] pow(int[][] matrix, long exp) {
    if (exp == 1) {
      return matrix;
    }

    int[][] half = pow(matrix, exp / 2);
    int[][] halfSquared = multiply(half, half);

    if (exp % 2 == 0) {
      return halfSquared;
    } else {
      return multiply(halfSquared, A);
    }
  }
  
  static int[][] multiply(int[][] m1, int[][] m2) {
    int[][] result = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          result[i][j] += (m1[i][k] * m2[k][j]) % MOD;
        }
        result[i][j] %= MOD;
      }
    }
    return result;
  }
}
