package baekjoon.step11;

import java.util.Scanner;

public class Main24267 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();

    long count = n * (n - 1) * (n - 2) / 6;

    System.out.println(count);
    System.out.println(3);
  }
}
