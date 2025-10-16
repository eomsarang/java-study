package baekjoon.step21;

import java.util.Arrays;
import java.util.Scanner;

public class Main11054 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }

    int[] LIS = new int[n];
    int[] LDS = new int[n];

    Arrays.fill(LIS, 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i]) {
          LIS[i] = Math.max(LIS[i], LIS[j] + 1);
        }
      }
    }

    Arrays.fill(LDS, 1);
    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j > i; j--) {
        if (A[j] < A[i]) {
          LDS[i] = Math.max(LDS[i], LDS[j] + 1);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, LIS[i] + LDS[i] - 1);
    }

    System.out.println(max);
  }
}
