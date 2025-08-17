package baekjoon.step08;

import java.util.Scanner;

public class Main2292 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();

    if (N == 1) {
      System.out.println(1);
      return;
    }

    long k = 1;
    long max = 1;

    while (max < N) {
      max = 3 * k * (k + 1) + 1;
      k++;
    }

    System.out.println(k);
  }
}
