package baekjoon.step41;

import java.util.Arrays;
import java.util.Scanner;

public class Main27312 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    int N = sc.nextInt();
    int Q = sc.nextInt();

    int[] a = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      a[i] = sc.nextInt();
    }

    int[] forbid = new int[N + 1];

    // 각 캐릭터 하나씩 질문
    for (int k = 1; k <= M; k++) {
      System.out.println("? " + k + " " + k);
      System.out.flush();
      forbid[k] = sc.nextInt();
    }

    int[] ans = new int[N + 1];
    Arrays.fill(ans, 1);

    for (int k = 1; k <= M; k++) {
      ans[k] = (forbid[k] % a[k]) + 1;
    }

    System.out.print("!");
    for (int i = 1; i <= N; i++) {
      System.out.print(" " + ans[i]);
    }
    System.out.println();
    System.out.flush();
  }
}
