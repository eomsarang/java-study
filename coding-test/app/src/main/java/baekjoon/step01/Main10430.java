package baekjoon.step01;

import java.util.Scanner;

public class Main10430 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();

    if (2 <= a && c <= 10000) {
      System.out.println((a + b) % c);
      System.out.println(((a % c) + (b % c)) % c);
      System.out.println((a * b) % c);
      System.out.println(((a % c) * (b % c)) % c);
    }
  }
}
