package baekjoon.step24;

import java.util.Scanner;

public class Main2740 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] A = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        A[i][j] = sc.nextInt();
      }
    }

    int M2 = sc.nextInt();
    int K = sc.nextInt();
    int[][] B = new int[M2][K];

    for (int i = 0; i < M2; i++) {
      for (int j = 0; j < K; j++) {
        B[i][j] = sc.nextInt();
      }
    }

    int[][] C = new int[N][K];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K; j++) {
        int sum = 0;
        for (int t = 0; t < M; t++) {
          sum += A[i][t] * B[t][j];
        }
        C[i][j] = sum;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K; j++) {
        sb.append(C[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
