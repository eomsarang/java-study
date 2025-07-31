package baekjoon.step04;

import java.util.Scanner;

public class Main10871 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();

    int[] arrN = new int[n];

    for (int i = 0; i < n; i++) {
      int input = sc.nextInt();
      arrN[i] += input;
    }

    for (int value : arrN) {
      if (value < x) {
        System.out.print(value + " ");
      }
    }

  }
}
