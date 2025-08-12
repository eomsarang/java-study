package baekjoon.step06;

import java.util.Scanner;

public class Main3003 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 올바른 체스 피스 개수
    int[] correct = {1, 1, 2, 2, 2, 8};

    int[] found = new int[6];
    for (int i = 0; i < 6; i++) {
      found[i] = sc.nextInt();
    }

    for (int i = 0; i < 6; i++) {
      System.out.print((correct[i] - found[i]) + " ");
    }
  }
}
